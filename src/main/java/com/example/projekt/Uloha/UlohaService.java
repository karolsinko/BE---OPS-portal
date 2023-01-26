package com.example.projekt.Uloha;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class UlohaService {

    private final UlohaRepository ulohaRepository;

    public UlohaService(UlohaRepository ulohaRepository) {
        this.ulohaRepository = ulohaRepository;
    }

    public static Uloha mapUlohy(UlohaEntity ulohaEntity){
        Uloha uloha = new Uloha(ulohaEntity.getId(), ulohaEntity.getContent(), ulohaEntity.getInput());

        uloha.setId(ulohaEntity.getId());
        uloha.setContent(ulohaEntity.getContent());
        uloha.setInput(ulohaEntity.getInput());
        return uloha;

    }

    @Transactional
    public List<Uloha> dostanOtazkuPodlaId() {
        List<Uloha> ret = new LinkedList<>();
        for (UlohaEntity u1 : ulohaRepository.findAll()){
            Uloha u2 = mapUlohy(u1);
            ret.add(u2);
        }
        return ret;
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
