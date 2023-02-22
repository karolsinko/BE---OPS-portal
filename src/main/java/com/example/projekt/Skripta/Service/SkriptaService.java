package com.example.projekt.Skripta.Service;

import com.example.projekt.Skripta.Entity.SkriptaEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Repository.SkriptaRepository;
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
        Skripta skripta = new Skripta(skriptaEntity.getId(), skriptaEntity.getContent(), skriptaEntity.getContent1(), skriptaEntity.getCommands(), skriptaEntity.getExplain(), skriptaEntity.getScripts());

        skripta.setId(skriptaEntity.getId());
        skripta.setContent(skriptaEntity.getContent());
        skripta.setContent1(skriptaEntity.getContent1());
        skripta.setCommands(skriptaEntity.getCommands());
        skripta.setExplain(skriptaEntity.getExplain());
        skripta.setScripts(skriptaEntity.getScripts());

        return skripta;

    }

    @Transactional
    public List<Skripta> dostanSkript() {
        List<Skripta> ret = new LinkedList<>();
        for (SkriptaEntity s1 : skriptaRepository.findAll()){
            Skripta s2 = mapSkripta(s1);
            ret.add(s2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorSkript(Skripta skripta){
        SkriptaEntity skriptaEntity = new SkriptaEntity();

        skriptaEntity.setContent(skripta.getContent());
        skriptaEntity.setContent1(skripta.getContent1());
        skriptaEntity.setCommands(skripta.getCommands());
        skriptaEntity.setExplain(skripta.getExplain());
        skriptaEntity.setScripts(skripta.getScripts());

        this.skriptaRepository.save(skriptaEntity);
        return skriptaEntity.getId();
    }

    @Transactional
    public Skripta dostanSkriptCezId(Long id) {
        for (SkriptaEntity s1 : skriptaRepository.findAll()){
            if (s1.getId() == (id)) {
                return mapSkripta(s1);
            }
        }
        return null;
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
