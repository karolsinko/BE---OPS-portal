package com.example.projekt.Skripta.Service;

import com.example.projekt.Skripta.Entity.SkriptaLinuxEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Repository.SkriptaLinuxRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class SkriptaLinuxService {
    private final SkriptaLinuxRepository skriptaLinuxRepository;

    public SkriptaLinuxService(SkriptaLinuxRepository skriptaLinuxRepository) {
        this.skriptaLinuxRepository = skriptaLinuxRepository;
    }

    public static Skripta mapSkripta(SkriptaLinuxEntity skriptaLinuxEntity){
        Skripta skripta = new Skripta(skriptaLinuxEntity.getId(), skriptaLinuxEntity.getContent(), skriptaLinuxEntity.getContent1(), skriptaLinuxEntity.getCommands(), skriptaLinuxEntity.getExplain(), skriptaLinuxEntity.getScripts());

        skripta.setId(skriptaLinuxEntity.getId());
        skripta.setContent(skriptaLinuxEntity.getContent());
        skripta.setContent1(skriptaLinuxEntity.getContent1());
        skripta.setCommands(skriptaLinuxEntity.getCommands());
        skripta.setExplain(skriptaLinuxEntity.getExplain());
        skripta.setScripts(skriptaLinuxEntity.getScripts());

        return skripta;

    }

    @Transactional
    public List<Skripta> dostanSkript() {
        List<Skripta> ret = new LinkedList<>();
        for (SkriptaLinuxEntity s1 : skriptaLinuxRepository.findAll()){
            Skripta s2 = mapSkripta(s1);
            ret.add(s2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorSkript(Skripta skripta){
        SkriptaLinuxEntity skriptaLinuxEntity = new SkriptaLinuxEntity();

        skriptaLinuxEntity.setContent(skripta.getContent());
        skriptaLinuxEntity.setContent1(skripta.getContent1());
        skriptaLinuxEntity.setCommands(skripta.getCommands());
        skriptaLinuxEntity.setExplain(skripta.getExplain());
        skriptaLinuxEntity.setScripts(skripta.getScripts());

        this.skriptaLinuxRepository.save(skriptaLinuxEntity);
        return skriptaLinuxEntity.getId();
    }

    @Transactional
    public Skripta dostanSkriptCezId(Long id) {
        for (SkriptaLinuxEntity s1 : skriptaLinuxRepository.findAll()){
            if (s1.getId() == (id)) {
                return mapSkripta(s1);
            }
        }
        return null;
    }

    public SkriptaLinuxEntity vytvorSkript(SkriptaLinuxEntity skriptaLinuxEntity) {
        return skriptaLinuxRepository.save(skriptaLinuxEntity);
    }

    public SkriptaLinuxEntity dostanSkriptPodlaId(Long id) {
        return skriptaLinuxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skript sa nenasiel"));
    }

    public SkriptaLinuxEntity modifikujSkript(Long id, SkriptaLinuxEntity skriptaLinuxEntity) {
        skriptaLinuxEntity.setId(id);
        return skriptaLinuxRepository.save(skriptaLinuxEntity);
    }

    public void vymazSkript(Long id) {
        skriptaLinuxRepository.deleteById(id);
    }

}
