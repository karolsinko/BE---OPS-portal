package com.example.projekt.Uloha.Service;

import com.example.projekt.Uloha.Entity.UlohaEntity;
import com.example.projekt.Uloha.Repository.UlohaRepository;
import com.example.projekt.Uloha.Model.Uloha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class UlohaService {

    private final UlohaRepository ulohaRepository;

    @Autowired
    public UlohaService(UlohaRepository ulohaRepository) {
        this.ulohaRepository = ulohaRepository;
    }

    //Service pre otazky vseobecne
    public static Uloha mapUlohy(UlohaEntity ulohaEntity){
        Uloha uloha = new Uloha(ulohaEntity.getId(), ulohaEntity.getContent(), ulohaEntity.getInput(), ulohaEntity.getSolution());

        uloha.setId(ulohaEntity.getId());
        uloha.setContent(ulohaEntity.getContent());
        uloha.setInput(ulohaEntity.getInput());
        uloha.setSolution(ulohaEntity.getSolution());

        return uloha;

    }

    @Transactional
    public List<Uloha> dostanOtazku() {
        List<Uloha> ret = new LinkedList<>();
        for (UlohaEntity u1 : ulohaRepository.findAll()){
            Uloha u2 = mapUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorUlohu(Uloha uloha){
        UlohaEntity ulohaEntity = new UlohaEntity();

        ulohaEntity.setContent( uloha.getContent());
        ulohaEntity.setInput(uloha.getInput());
        ulohaEntity.setSolution(uloha.getSolution());

        this.ulohaRepository.save(ulohaEntity);
        return ulohaEntity.getId();
    }

    @Transactional
    public Uloha dostanOtazkuCezId(Long id) {
        for (UlohaEntity u1 : ulohaRepository.findAll()){
            if (u1.getId() == (id)) {
                return mapUlohy(u1);
            }
        }
        return null;
    }

    public UlohaEntity vytvorUlohu(UlohaEntity ulohaEntity) {
        return ulohaRepository.save(ulohaEntity);
    }

    public UlohaEntity dostanOtazkuPodlaId(Long id) {
        return ulohaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public UlohaEntity modifikujOtazku(Long id, UlohaEntity ulohaEntity) {
        ulohaEntity.setId(id);
        return ulohaRepository.save(ulohaEntity);
    }

    public void vymazOtazku(Long id) {
        ulohaRepository.deleteById(id);
    }

}
