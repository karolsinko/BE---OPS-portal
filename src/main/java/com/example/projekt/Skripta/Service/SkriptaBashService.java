package com.example.projekt.Skripta.Service;

import com.example.projekt.Skripta.Entity.SkriptaBashEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Repository.SkriptaBashRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class SkriptaBashService {

    private final SkriptaBashRepository skriptaBashRepository;

    public SkriptaBashService(SkriptaBashRepository skriptaBashRepository) {
        this.skriptaBashRepository = skriptaBashRepository;
    }

    public static Skripta mapSkripta(SkriptaBashEntity skriptaBashEntity){
        Skripta skripta = new Skripta(skriptaBashEntity.getId(), skriptaBashEntity.getContent(), skriptaBashEntity.getContent1(), skriptaBashEntity.getCommands(), skriptaBashEntity.getExplain(), skriptaBashEntity.getScripts());

        skripta.setId(skriptaBashEntity.getId());
        skripta.setContent(skriptaBashEntity.getContent());
        skripta.setContent1(skriptaBashEntity.getContent1());
        skripta.setCommands(skriptaBashEntity.getCommands());
        skripta.setExplain(skriptaBashEntity.getExplain());
        skripta.setScripts(skriptaBashEntity.getScripts());

        return skripta;

    }

    @Transactional
    public List<Skripta> dostanSkript() {
        List<Skripta> ret = new LinkedList<>();
        for (SkriptaBashEntity s1 : skriptaBashRepository.findAll()){
            Skripta s2 = mapSkripta(s1);
            ret.add(s2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorSkript(Skripta skripta){
        SkriptaBashEntity skriptaBashEntity = new SkriptaBashEntity();

        skriptaBashEntity.setContent(skripta.getContent());
        skriptaBashEntity.setContent1(skripta.getContent1());
        skriptaBashEntity.setCommands(skripta.getCommands());
        skriptaBashEntity.setExplain(skripta.getExplain());
        skriptaBashEntity.setScripts(skripta.getScripts());

        this.skriptaBashRepository.save(skriptaBashEntity);
        return skriptaBashEntity.getId();
    }

    @Transactional
    public Skripta dostanSkriptCezId(Long id) {
        for (SkriptaBashEntity s1 : skriptaBashRepository.findAll()){
            if (s1.getId() == (id)) {
                return mapSkripta(s1);
            }
        }
        return null;
    }

    public SkriptaBashEntity vytvorSkript(SkriptaBashEntity skriptaBashEntity) {
        return skriptaBashRepository.save(skriptaBashEntity);
    }

    public SkriptaBashEntity dostanSkriptPodlaId(Long id) {
        return skriptaBashRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skript sa nenasiel"));
    }

    public SkriptaBashEntity modifikujSkript(Long id, SkriptaBashEntity skriptaBashEntity) {
        skriptaBashEntity.setId(id);
        return skriptaBashRepository.save(skriptaBashEntity);
    }

    public void vymazSkript(Long id) {
        skriptaBashRepository.deleteById(id);
    }
}
