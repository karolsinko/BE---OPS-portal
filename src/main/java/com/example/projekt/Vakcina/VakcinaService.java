package com.example.projekt.Vakcina;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VakcinaService {

    private  final VakcinaRepository vakcinaRepository;

    public VakcinaService(VakcinaRepository vakcinaRepository){
        this.vakcinaRepository = vakcinaRepository;
    }

    private static Vakcina mapVakcina(VakcinaEntity vakcinaEntity){
        Vakcina vakcina = new Vakcina();

        vakcina.setId(vakcinaEntity.getId());
        vakcina.setNazov(vakcinaEntity.getNazov());
        vakcina.setPocet_davok(vakcinaEntity.getPocet_davok());
        return vakcina;

    }

    @Transactional
    public List<Vakcina> getVakcinaByNazov(String nazov){
        List<Vakcina> ret = new LinkedList<>();
        List<VakcinaEntity> vakciny = new LinkedList<>();
        if(nazov == null) {
           vakciny = vakcinaRepository.findAll();
        }else {
            Optional <VakcinaEntity>foundVakciny = vakcinaRepository.findByNazov(nazov);
            if(foundVakciny.isPresent()){
                vakciny.add(foundVakciny.get());
            }
        }
        for (VakcinaEntity v1 : vakciny) {
            Vakcina v2 = mapVakcina(v1);
            ret.add(v2);
        }
        return ret;
    }

    @Transactional
    public int createVakcina(Vakcina vakcina){
        VakcinaEntity vakcinaEntity = new VakcinaEntity();

        vakcinaEntity.setNazov(vakcina.getNazov());
        vakcinaEntity.setPocet_davok(vakcina.getPocet_davok());

        this.vakcinaRepository.save(vakcinaEntity);
        return vakcinaEntity.getId();
    }

    @Transactional
    public Vakcina getVakcinaById(int id){
        for(VakcinaEntity v1 : vakcinaRepository.findAll()){
            if(v1.getId() == (id)){
                Vakcina v2 = mapVakcina(v1);
                return v2;
            }
        }
        return null;
    }

    @Transactional
    public void deleteVakcina(int id){
        Optional<VakcinaEntity> byId = vakcinaRepository.findById(id);
        if(byId.isPresent()){
            vakcinaRepository.delete(byId.get());
        }
    }

    @Transactional
    public void updateVakcina(int id , Vakcina vakcina) {
        Optional<VakcinaEntity> byId = vakcinaRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setId(vakcina.getId());
            byId.get().setNazov(vakcina.getNazov());
            byId.get().setPocet_davok(vakcina.getPocet_davok());

        }
    }
}
