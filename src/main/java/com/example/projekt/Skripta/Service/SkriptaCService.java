package com.example.projekt.Skripta.Service;

import com.example.projekt.Skripta.Entity.SkriptaCEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Repository.SkriptaCRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class SkriptaCService {

    private final SkriptaCRepository skriptaCRepository;

    public SkriptaCService(SkriptaCRepository skriptaCRepository) {
        this.skriptaCRepository = skriptaCRepository;
    }

    public static Skripta mapSkripta(SkriptaCEntity skriptaCEntity){
        Skripta skripta = new Skripta(skriptaCEntity.getId(), skriptaCEntity.getContent(), skriptaCEntity.getContent1(), skriptaCEntity.getCommands(), skriptaCEntity.getExplain(), skriptaCEntity.getScripts());

        skripta.setId(skriptaCEntity.getId());
        skripta.setContent(skriptaCEntity.getContent());
        skripta.setContent1(skriptaCEntity.getContent1());
        skripta.setCommands(skriptaCEntity.getCommands());
        skripta.setExplain(skriptaCEntity.getExplain());
        skripta.setScripts(skriptaCEntity.getScripts());

        return skripta;

    }

    @Transactional
    public List<Skripta> dostanSkript() {
        List<Skripta> ret = new LinkedList<>();
        for (SkriptaCEntity s1 : skriptaCRepository.findAll()){
            Skripta s2 = mapSkripta(s1);
            ret.add(s2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorSkript(Skripta skripta){
        SkriptaCEntity skriptaCEntity = new SkriptaCEntity();

        skriptaCEntity.setContent(skripta.getContent());
        skriptaCEntity.setContent1(skripta.getContent1());
        skriptaCEntity.setCommands(skripta.getCommands());
        skriptaCEntity.setExplain(skripta.getExplain());
        skriptaCEntity.setScripts(skripta.getScripts());

        this.skriptaCRepository.save(skriptaCEntity);
        return skriptaCEntity.getId();
    }

    @Transactional
    public Skripta dostanSkriptCezId(Long id) {
        for (SkriptaCEntity s1 : skriptaCRepository.findAll()){
            if (s1.getId() == (id)) {
                return mapSkripta(s1);
            }
        }
        return null;
    }

    public SkriptaCEntity vytvorSkript(SkriptaCEntity skriptaCEntity) {
        return skriptaCRepository.save(skriptaCEntity);
    }

    public SkriptaCEntity dostanSkriptPodlaId(Long id) {
        return skriptaCRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skript sa nenasiel"));
    }

    public SkriptaCEntity modifikujSkript(Long id, SkriptaCEntity skriptaCEntity) {
        skriptaCEntity.setId(id);
        return skriptaCRepository.save(skriptaCEntity);
    }

    public void vymazSkript(Long id) {
        skriptaCRepository.deleteById(id);
    }

}
