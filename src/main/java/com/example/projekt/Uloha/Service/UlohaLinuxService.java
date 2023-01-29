package com.example.projekt.Uloha.Service;

import com.example.projekt.Uloha.Entity.UlohaEntity;
import com.example.projekt.Uloha.Entity.UlohaLinuxEntity;
import com.example.projekt.Uloha.Repository.UlohaLinuxRepository;
import com.example.projekt.Uloha.Uloha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class UlohaLinuxService {

    private final UlohaLinuxRepository ulohaLinuxRepository;

    @Autowired
    public UlohaLinuxService(UlohaLinuxRepository ulohaLinuxRepository) {
        this.ulohaLinuxRepository = ulohaLinuxRepository;
    }

    //Service pre Linux otazky vseobecne
    public static Uloha mapLinuxUlohy(UlohaLinuxEntity ulohaLinuxEntity){
        Uloha uloha = new Uloha(ulohaLinuxEntity.getId(), ulohaLinuxEntity.getContent(), ulohaLinuxEntity.getInput(), ulohaLinuxEntity.getSolution(), ulohaLinuxEntity.getLanguage());

        uloha.setId(ulohaLinuxEntity.getId());
        uloha.setContent(ulohaLinuxEntity.getContent());
        uloha.setInput(ulohaLinuxEntity.getInput());
        uloha.setSolution(ulohaLinuxEntity.getSolution());
        uloha.setLanguage(ulohaLinuxEntity.getLanguage());

        return uloha;

    }

    @Transactional
    public List<Uloha> dostanLinuxOtazku() {
        List<Uloha> ret = new LinkedList<>();
        for (UlohaLinuxEntity u1 : ulohaLinuxRepository.findAll()){
            Uloha u2 = mapLinuxUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorLinuxUlohu(Uloha uloha){
        UlohaLinuxEntity ulohaLinuxEntity = new UlohaLinuxEntity();

        ulohaLinuxEntity.setContent( uloha.getContent());
        ulohaLinuxEntity.setInput(uloha.getInput());
        ulohaLinuxEntity.setSolution(uloha.getSolution());
        ulohaLinuxEntity.setLanguage(uloha.getLanguage());

        this.ulohaLinuxRepository.save(ulohaLinuxEntity);
        return ulohaLinuxEntity.getId();
    }

    @Transactional
    public Uloha dostanLinuxOtazkuCezId(Long id) {
        for (UlohaLinuxEntity u1 : ulohaLinuxRepository.findAll()){
            if (u1.getId() == (id)) {
                return mapLinuxUlohy(u1);
            }
        }
        return null;
    }

    public UlohaLinuxEntity vytvorLinuxUlohu(UlohaLinuxEntity ulohaLinuxEntity) {
        return ulohaLinuxRepository.save(ulohaLinuxEntity);
    }

    public UlohaLinuxEntity dostanLinuxOtazkuPodlaId(Long id) {
        return ulohaLinuxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public UlohaLinuxEntity modifikujLinuxOtazku(Long id, UlohaLinuxEntity ulohaLinuxEntity) {
        ulohaLinuxEntity.setId(id);
        return ulohaLinuxRepository.save(ulohaLinuxEntity);
    }

    public void vymazCOtazku(Long id) {
        ulohaLinuxRepository.deleteById(id);
    }

}
