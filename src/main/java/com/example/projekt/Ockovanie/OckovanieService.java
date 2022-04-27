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

    private static Ockovanie mapToOckovanie(OckovanieEntity ockovanieEntity) {
        Ockovanie ockovanie = new Ockovanie();

        ockovanie.setOckovanieId((int)ockovanieEntity.getOckovanieId());
        ockovanie.setOsobaId((int)ockovanieEntity.getOsoba().getId());
        ockovanie.setVakcinaId((int)ockovanieEntity.getVakcina().getId());
        /*
        ockovanie.setMeno(ockovanieEntity.getOsoba().getMeno());
        ockovanie.setPriezvisko(ockovanieEntity.getOsoba().getPriezvisko());
        ockovanie.setRodCislo(ockovanieEntity.getOsoba().getRodCislo());
         */
        ockovanie.setDatumOckovania(ockovanieEntity.getDatumOckovania());


        return ockovanie;
    }

    @Transactional
    public Ockovanie getOckovanie(int id) {
        Optional<OckovanieEntity> byId = ockovanieRepository.findById(id);
        if (byId.isPresent()) {
            return mapToOckovanie(byId.get());
        }
        return null;
    }

    @Transactional
    public List<Ockovanie> getOckovania(int id) {
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

        if(o.isPresent()) {
            ockovanieEntity.setOsoba(o.get());
        }

        if(v.isPresent()) {
            ockovanieEntity.setVakcina(v.get());
        }
        ockovanieEntity.setDatumOckovania(ockovanie.getDatumOckovania());


        this.ockovanieRepository.save(ockovanieEntity);

        return ockovanieEntity.getOckovanieId();
    }

    @Transactional
    public void updateOckovanie(int id, Ockovanie ockovanie) {
        Optional<OckovanieEntity> ockovanieEntity = ockovanieRepository.findById(id);

        if (ockovanieEntity.isPresent()) {

            Optional <OsobaEntity> o = osobaRepository.findById(Math.toIntExact(ockovanie.getOsobaId()));
            Optional <VakcinaEntity> v = vakcinaRepository.findById(Math.toIntExact(ockovanie.getVakcinaId()));


            if(o.isPresent()) {
                ockovanieEntity.get().setOsoba(o.get());
            }

            if(v.isPresent()) {
                ockovanieEntity.get().setVakcina(v.get());
            }

            ockovanieEntity.get().setDatumOckovania(ockovanie.getDatumOckovania());


        }
    }

    @Transactional
    public void deleteOckovanie(int id) {
        Optional<OckovanieEntity> byId = ockovanieRepository.findById(id);
        if (byId.isPresent()) {
            ockovanieRepository.delete(byId.get());
        }
    }
    @Transactional
    public List<OckovanieEntity> getVsetkyOckovania(){
        return ockovanieRepository.findAll();
    }


}
