package com.example.projekt;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VakcinaService {

    private List<Vakcina> vakciny;

    public VakcinaService(){
        this.vakciny = init();
    }

    public List<Vakcina> init(){
        List<Vakcina> vakciny = new ArrayList<>();
        Vakcina vakcina1 = new Vakcina();
        vakcina1.setId(1);
        vakcina1.setNazov("Pfizer");
        vakcina1.setPocet_davok(2);

        vakciny.add(vakcina1);

        Vakcina vakcina2 = new Vakcina();
        vakcina2.setId(2);
        vakcina2.setNazov("Sputnik");
        vakcina2.setPocet_davok(1);
        vakciny.add(vakcina2);
        return vakciny;
    }


    public List<Vakcina> getVakcinaByNazov(String nazov){
        if (nazov == null){
            return this.vakciny;
        }

        List<Vakcina> filteredVakciny = new ArrayList<>();

        for (Vakcina vakcina : vakciny){
            if (vakcina.getNazov().equals(nazov)){
                filteredVakciny.add(vakcina);
            }
        }

        return filteredVakciny;
    }


    public List<Vakcina> getVakcinaById(int id){
        if (id == 0){
            return this.vakciny;
        }

        List<Vakcina> filteredVakciny = new ArrayList<>();

        for (Vakcina vakcina : vakciny){
            if (vakcina.getId()==(id)){
                filteredVakciny.add(vakcina);
            }
        }

        return filteredVakciny;
    }


    public List<Vakcina> createVakcina(Vakcina vakcina){
        this.vakciny.add(vakcina);

        return vakciny;
    }


    public List<Vakcina> updateVakcina(int id, Vakcina vakcina){
        this.vakciny.get(id).setId(vakcina.getId());
        this.vakciny.get(id).setNazov(vakcina.getNazov());
        this.vakciny.get(id).setPocet_davok(vakcina.getPocet_davok());


        return vakciny;
    }


    public void deleteVakcina(int id){
        this.vakciny.remove(this.vakciny.get(id));
    }


}
