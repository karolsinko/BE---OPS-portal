package com.example.projekt.Skripta;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class SkriptaService {


    private final SkriptaRepository skriptaRepository;

    public SkriptaService(SkriptaRepository skriptaRepository) {
        this.skriptaRepository = skriptaRepository;
    }

    public static Skripta mapSkripta(SkriptaEntity skriptaEntity){
        Skripta skripta = new Skripta(skriptaEntity.getId(), skriptaEntity.getContent(), skriptaEntity.getContent1());

        skripta.setId(skriptaEntity.getId());
        skripta.setContent(skriptaEntity.getContent());
        skripta.setContent1(skriptaEntity.getContent1());
        return skripta;

    }

    @Transactional
    public List<Skripta> dostanSkriptPodlaId() {
        List<Skripta> ret = new LinkedList<>();
        for (SkriptaEntity s1 : skriptaRepository.findAll()){
            Skripta s2 = mapSkripta(s1);
            ret.add(s2);
        }
        return ret;
    }

    public SkriptaEntity vytvorSkript(SkriptaEntity skriptaEntity) {
        return skriptaRepository.save(skriptaEntity);
    }

    public SkriptaEntity dostanSkriptPodlaId(Long id) {
        return skriptaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skript sa nenasiel"));
    }

    public SkriptaEntity modifikujSkript(Long id, SkriptaEntity skriptaEntity) {
        skriptaEntity.setId(id);
        return skriptaRepository.save(skriptaEntity);
    }

    public void vymazSkript(Long id) {
        skriptaRepository.deleteById(id);
    }

}
