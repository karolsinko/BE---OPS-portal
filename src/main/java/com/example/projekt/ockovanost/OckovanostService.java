package com.example.projekt.ockovanost;

import com.example.projekt.osoba.OsobaEntity;
import com.example.projekt.osoba.OsobaRepository;
import com.example.projekt.vakcina.VakcinaEntity;
import com.example.projekt.vakcina.VakcinaRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class OckovanostService {
    private final OckovanostRepository ockovanostRepository;
    private final OsobaRepository osobaRepository;
    private final VakcinaRepository vakcinaRepository;

    public  OckovanostService(OckovanostRepository ockovanostRepository, OsobaRepository osobaRepository, VakcinaRepository vakcinaRepository){
        this.ockovanostRepository = ockovanostRepository;
        this.osobaRepository = osobaRepository;
        this.vakcinaRepository = vakcinaRepository;
    }

    private static Ockovanost mapOckovanost(OckovanostEntity ockovanostEntity){
        Ockovanost ockovanost = new Ockovanost();

        ockovanost.setDatum(ockovanostEntity.getDatum());
        ockovanost.setMenoOsoba(ockovanostEntity.getOsoba().getMeno()+" "+ockovanostEntity.getOsoba().getPriezvisko());
        ockovanost.setNazovVakcina(ockovanostEntity.getVakcina().getNazov());

        return ockovanost;
    }


    @Transactional
    public List<Ockovanost> getOckovanostByDatum(String datum) {
        List<Ockovanost> ret = new LinkedList<>();
        List<OckovanostEntity> ockovanie = new LinkedList<>();
        if(datum == null) {
            ockovanie = ockovanostRepository.findAll();
        }else {
            Optional <OckovanostEntity>foundOckovanie = ockovanostRepository.findByDatum(datum);
            if(foundOckovanie.isPresent()){
                ockovanie.add(foundOckovanie.get());
            }
        }
        for (OckovanostEntity o1 : ockovanie){
            Ockovanost o2 = mapOckovanost(o1);
            ret.add(o2);
        }
        return ret;
    }

    @Transactional
    public int createOckovanost(Ockovanie ockovanie){

        OckovanostEntity ockovanostEntity = new OckovanostEntity();

        Optional<OsobaEntity> najdenaOsoba = osobaRepository.findById(ockovanie.getOsobaId());
        if(najdenaOsoba.isEmpty()){
            throw new RuntimeException();
        }

        ockovanostEntity.setOsoba(najdenaOsoba.get());

        Optional<VakcinaEntity> najdenaVakcina = vakcinaRepository.findById(ockovanie.getVakcinaId());
        if(najdenaVakcina.isEmpty()){
            throw new RuntimeException();
        }
        ockovanostEntity.setVakcina(najdenaVakcina.get());

        ockovanostEntity.setDatum(LocalDate.now());

        this.ockovanostRepository.save(ockovanostEntity);
        return ockovanostEntity.getId();
    }


    @Transactional
    public Ockovanost getOckovanostById(int id){
        for(OckovanostEntity o1 : ockovanostRepository.findAll()){
            if (o1.getId() == (id)){
                Ockovanost o2 = mapOckovanost(o1);
                return o2;
            }
        }
        return null;
    }

    @Transactional
    public void deleteOckovanost(int id){
        Optional<OckovanostEntity> byId = ockovanostRepository.findById(id);
        if (byId.isPresent()){
            ockovanostRepository.delete(byId.get());
        }
    }

}
