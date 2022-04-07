package com.example.projekt;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OsobaService {

    private List<Osoba> osoby;

    public OsobaService(){
        this.osoby = init();
    }

    public List<Osoba> init(){
        List<Osoba> osoby = new ArrayList<>();
        Osoba osoba1 = new Osoba();
        osoba1.setId(1);
        osoba1.setMeno("Michal");
        osoba1.setPriezvisko("Obor");
        osoba1.setRok_Nar("2005");
        osoba1.setRod_Cislo("012345/6789");
        osoba1.setTel_cislo("+421987654321");
        osoba1.setBydlisko("Brezno");
        osoba1.setPohlavie("Muž");
        osoby.add(osoba1);

        Osoba osoba2 = new Osoba();
        osoba2.setId(2);
        osoba2.setMeno("Petra");
        osoba2.setPriezvisko("Nová");
        osoba2.setRok_Nar("1978");
        osoba2.setRod_Cislo("987654/3210");
        osoba2.setTel_cislo("+421123456789");
        osoba2.setBydlisko("Košice");
        osoba2.setPohlavie("Žena");
        osoby.add(osoba2);
        return osoby;
    }


    public List<Osoba> getOsobaByPriezvisko(String priezvisko){
        if (priezvisko == null){
            return this.osoby;
        }

        List<Osoba> filteredOsoby = new ArrayList<>();

        for (Osoba osoba : osoby){
            if (osoba.getPriezvisko().equals(priezvisko)){
                filteredOsoby.add(osoba);
            }
        }

        return filteredOsoby;
    }


    public List<Osoba> getOsobaById(int id){
        if (id == 0){
            return this.osoby;
        }

        List<Osoba> filteredOsoby = new ArrayList<>();

        for (Osoba osoba : osoby){
            if (osoba.getId()==(id)){
                filteredOsoby.add(osoba);
            }
        }

        return filteredOsoby;
    }


    public List<Osoba> createOsoba(Osoba osoba){
        this.osoby.add(osoba);

        return osoby;
    }


    public List<Osoba> updateOsoba(int id, Osoba osoba){
        this.osoby.get(id).setId(osoba.getId());
        this.osoby.get(id).setMeno(osoba.getMeno());
        this.osoby.get(id).setPriezvisko(osoba.getPriezvisko());
        this.osoby.get(id).setRok_Nar(osoba.getRok_Nar());
        this.osoby.get(id).setRod_Cislo(osoba.getRod_Cislo());
        this.osoby.get(id).setTel_cislo(osoba.getTel_cislo());
        this.osoby.get(id).setBydlisko(osoba.getBydlisko());
        this.osoby.get(id).setPohlavie(osoba.getPohlavie());

        return osoby;
    }


    public void deleteOsoba(int id){
        this.osoby.remove(this.osoby.get(id));
    }


}
