package com.example.projekt.Ockovanost;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Osoba.OsobaEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OckovanostService {

    private final OckovanostRepository ockovanostRepository;

    public OckovanostService(OckovanostRepository ockovanostRepository){
        this.ockovanostRepository = ockovanostRepository;
    }

    private static Ockovanost mapOckovanie(OckovanostEntity ockovanostEntity){
        Ockovanost ockovanost = new Ockovanost();

        ockovanost.setId(ockovanostEntity.getId());
        return ockovanost;
    }

    @Transactional
    public int createOckovanost(Ockovanost ockovanost){
        OckovanostEntity ockovanostEntity = new OckovanostEntity();


        this.ockovanostRepository.save(ockovanostEntity);
        return ockovanostEntity.getId();
    }

    @Transactional
    public Ockovanost getOckovanostById(int id){
        for (OckovanostEntity o1 : OckovanostRepository.findAll()){
            if (o1.getId() == (id)){
                return mapOckovanie(o1);
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

    @Transactional
    public void updateOckovanost(int id, Ockovanost ockovanost){
        Optional<OckovanostEntity> byId = OckovanostRepository.findById(id);
        if (byId.isPresent()){

        }
    }
}
