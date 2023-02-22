package com.example.projekt.Uloha.Service;

import com.example.projekt.Uloha.Entity.UlohaBashEntity;
import com.example.projekt.Uloha.Repository.UlohaBashRepository;
import com.example.projekt.Uloha.Model.Uloha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class UlohaBashService {

    private final UlohaBashRepository ulohaBashRepository;

    @Autowired
    public UlohaBashService(UlohaBashRepository ulohaBashRepository) {
        this.ulohaBashRepository = ulohaBashRepository;
    }

    //Service pre C otazky vseobecne
    public static Uloha mapBashUlohy(UlohaBashEntity ulohaBashEntity){
        Uloha uloha = new Uloha(ulohaBashEntity.getId(), ulohaBashEntity.getContent(), ulohaBashEntity.getInput(), ulohaBashEntity.getSolution());

        uloha.setId(ulohaBashEntity.getId());
        uloha.setContent(ulohaBashEntity.getContent());
        uloha.setInput(ulohaBashEntity.getInput());
        uloha.setSolution(ulohaBashEntity.getSolution());

        return uloha;

    }

    @Transactional
    public List<Uloha> dostanBashOtazku() {
        List<Uloha> ret = new LinkedList<>();
        for (UlohaBashEntity u1 : ulohaBashRepository.findAll()){
            Uloha u2 = mapBashUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorBashUlohu(Uloha uloha){
        UlohaBashEntity ulohaBashEntity = new UlohaBashEntity();

        ulohaBashEntity.setContent( uloha.getContent());
        ulohaBashEntity.setInput(uloha.getInput());
        ulohaBashEntity.setSolution(uloha.getSolution());

        this.ulohaBashRepository.save(ulohaBashEntity);
        return ulohaBashEntity.getId();
    }

    @Transactional
    public Uloha dostanBashOtazkuCezId(Long id) {
        for (UlohaBashEntity u1 : ulohaBashRepository.findAll()){
            if (u1.getId() == (id)) {
                return mapBashUlohy(u1);
            }
        }
        return null;
    }

    public UlohaBashEntity vytvorBashUlohu(UlohaBashEntity ulohaBashEntity) {
        return ulohaBashRepository.save(ulohaBashEntity);
    }

    public UlohaBashEntity dostanBashOtazkuPodlaId(Long id) {
        return ulohaBashRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public UlohaBashEntity modifikujBashOtazku(Long id, UlohaBashEntity ulohaBashEntity) {
        ulohaBashEntity.setId(id);
        return ulohaBashRepository.save(ulohaBashEntity);
    }

    public void vymazBashOtazku(Long id) {
        ulohaBashRepository.deleteById(id);
    }
}
