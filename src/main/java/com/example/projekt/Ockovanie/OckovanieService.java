package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.OsobaEntity;
import com.example.projekt.Osoba.OsobaRepository;
import com.example.projekt.Osoba.OsobaService;
import com.example.projekt.Vakcina.VakcinaEntity;
import com.example.projekt.Vakcina.VakcinaRepository;
import com.example.projekt.Vakcina.VakcinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OckovanieService{
    private final OckovanieRepository ockovanieRepository;
    private final OsobaRepository osobaRepository;
    private final VakcinaRepository vakcinaRepository;

    @Autowired
    private final OsobaService osobaService;
    @Autowired
    private final VakcinaService vakcinaService;


    public OckovanieService(OckovanieRepository ockovanieRepository,OsobaRepository osobaRepository, VakcinaRepository vakcinaRepository, OsobaService osobaService, VakcinaService vakcinaService) {
        this.ockovanieRepository = ockovanieRepository;
        this.osobaRepository= osobaRepository;
        this.vakcinaRepository=vakcinaRepository;
        this.osobaService=osobaService;
        this.vakcinaService=vakcinaService;
    }

    public Ockovanie mapToOckovanie(OckovanieEntity ockovanieEntity) {
        Ockovanie ockovanie = new Ockovanie();

        ockovanie.setId(ockovanieEntity.getOckovanieId());
        ockovanie.setOsobaId(OsobaService.mapOsoba(ockovanieEntity.getOsoba()).getId());
        ockovanie.setVakcinaId(VakcinaService.mapVakcina(ockovanieEntity.getVakcina()).getId());

        ockovanie.setDatum(ockovanieEntity.getDatum());


        return ockovanie;
    }

    @Transactional
    public Ockovanie getOckovanie(int id) {
        Optional<OckovanieEntity> byId = ockovanieRepository.findById(id);
        return byId.map(this::mapToOckovanie).orElse(null);
    }

    @Transactional
    public List<Ockovanie> getOckovania() {
        List<Ockovanie> ockovanie = new LinkedList<>();
        for (OckovanieEntity o1 : ockovanieRepository.findAll()) {
            Ockovanie o2 = mapToOckovanie(o1);
            ockovanie.add(o2);
        }
        return ockovanie;
    }

    @Transactional
    public int createOckovanie(Ockovanie ockovanie) {
        OckovanieEntity ockovanieEntity = new OckovanieEntity();

        Optional <OsobaEntity> o = osobaRepository.findById(Math.toIntExact(ockovanie.getOsobaId()));
        Optional <VakcinaEntity> v = vakcinaRepository.findById(Math.toIntExact(ockovanie.getVakcinaId()));

        o.ifPresent(ockovanieEntity::setOsoba);

        v.ifPresent(ockovanieEntity::setVakcina);
        ockovanieEntity.setDatum(ockovanie.getDatum());


        this.ockovanieRepository.save(ockovanieEntity);

        return ockovanieEntity.getOckovanieId();
    }

    @Transactional
    public void updateOckovanie(int id, Ockovanie ockovanie) {
        Optional<OckovanieEntity> ockovanieEntity = ockovanieRepository.findById(id);

        if (ockovanieEntity.isPresent()) {

            Optional <OsobaEntity> o = osobaRepository.findById(Math.toIntExact(ockovanie.getOsobaId()));
            Optional <VakcinaEntity> v = vakcinaRepository.findById(Math.toIntExact(ockovanie.getVakcinaId()));


            o.ifPresent(osobaEntity -> ockovanieEntity.get().setOsoba(osobaEntity));

            v.ifPresent(vakcinaEntity -> ockovanieEntity.get().setVakcina(vakcinaEntity));

            ockovanieEntity.get().setDatum(ockovanie.getDatum());


        }
    }

    @Transactional
    public void deleteOckovanie(int id) {
        Optional<OckovanieEntity> byId = ockovanieRepository.findById(id);
        byId.ifPresent(ockovanieRepository::delete);
    }
    @Transactional
    public List<OckovanieEntity> getVsetkyOckovania(){
        return ockovanieRepository.findAll();
    }


}
