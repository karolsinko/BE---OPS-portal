package com.example.projekt.Osoba;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OsobaService {
    private final OsobaRepository osobaRepository;

    public OsobaService(OsobaRepository osobaRepository){
        this.osobaRepository = osobaRepository;
    }

    public static Osoba mapOsoba(OsobaEntity osobaEntity){
        Osoba osoba = new Osoba();

        osoba.setId(osobaEntity.getId());
        osoba.setMeno(osobaEntity.getMeno());
        osoba.setPriezvisko(osobaEntity.getPriezvisko());
        osoba.setRok_nar(osobaEntity.getRok_nar());
        osoba.setRod_cislo(osobaEntity.getRod_cislo());
        osoba.setBydlisko(osobaEntity.getBydlisko());
        osoba.setPohlavie(osobaEntity.getPohlavie());
        osoba.setTel_cislo(osobaEntity.getTel_cislo());

        return osoba;
    }

    @Transactional
    public List<Osoba> getOsobaByPriezvisko(String priezvisko) {
        List<Osoba> ret = new LinkedList<>();
        List<OsobaEntity> osoby = new LinkedList<>();
        if(priezvisko == null) {
            osoby = osobaRepository.findAll();
        }else {
            Optional <OsobaEntity>foundOsoby = osobaRepository.findByPriezvisko(priezvisko);
            if(foundOsoby.isPresent()){
                osoby.add(foundOsoby.get());
            }
        }
        for (OsobaEntity o1 : osoby){
            Osoba o2 = mapOsoba(o1);
            ret.add(o2);
        }
        return ret;
    }

    @Transactional
    public int createOsoba(Osoba osoba){
        OsobaEntity osobaEntity = new OsobaEntity();

        osobaEntity.setMeno(osoba.getMeno());
        osobaEntity.setPriezvisko(osoba.getPriezvisko());
        osobaEntity.setRok_nar(osoba.getRok_nar());
        osobaEntity.setRod_cislo(osoba.getRod_cislo());
        osobaEntity.setBydlisko(osoba.getBydlisko());
        osobaEntity.setPohlavie(osoba.getPohlavie());
        osobaEntity.setTel_cislo(osoba.getTel_cislo());

        this.osobaRepository.save(osobaEntity);
        return osobaEntity.getId();
    }
    @Transactional
    public Osoba getOsobaById(int id){
        for (OsobaEntity o1 : osobaRepository.findAll()){
            if (o1.getId() == (id)){
                Osoba o2 = mapOsoba(o1);
                return o2;
            }
        }
        return null;
    }

    @Transactional
    public void deleteOsoba(int id){
        Optional<OsobaEntity> byId = osobaRepository.findById(id);
        if (byId.isPresent()){
            osobaRepository.delete(byId.get());
        }
    }

    @Transactional
    public void updateOsoba(int id, Osoba osoba){
        Optional<OsobaEntity> byId = osobaRepository.findById(id);
        if (byId.isPresent()){
            byId.get().setId(osoba.getId());
            byId.get().setMeno(osoba.getMeno());
            byId.get().setPriezvisko(osoba.getPriezvisko());
            byId.get().setRok_nar(osoba.getRok_nar());
            byId.get().setRod_cislo(osoba.getRod_cislo());
            byId.get().setBydlisko(osoba.getBydlisko());
            byId.get().setBydlisko(osoba.getBydlisko());
            byId.get().setPohlavie(osoba.getPohlavie());
            byId.get().setTel_cislo(osoba.getTel_cislo());
        }
    }


}
