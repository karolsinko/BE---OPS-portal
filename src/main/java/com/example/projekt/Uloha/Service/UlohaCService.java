package com.example.projekt.Uloha.Service;

import com.example.projekt.Uloha.Entity.UlohaCEntity;
import com.example.projekt.Uloha.Repository.UlohaCRepository;
import com.example.projekt.Uloha.Model.Uloha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class UlohaCService {

    private final UlohaCRepository ulohaCRepository;

    @Autowired
    public UlohaCService(UlohaCRepository ulohaCRepository) {
        this.ulohaCRepository = ulohaCRepository;
    }

    //Service pre C otazky vseobecne
    public static Uloha mapCUlohy(UlohaCEntity ulohaCEntity){
        Uloha uloha = new Uloha(ulohaCEntity.getId(), ulohaCEntity.getContent(), ulohaCEntity.getInput(), ulohaCEntity.getSolution());

        uloha.setId(ulohaCEntity.getId());
        uloha.setContent(ulohaCEntity.getContent());
        uloha.setInput(ulohaCEntity.getInput());
        uloha.setSolution(ulohaCEntity.getSolution());

        return uloha;

    }

    @Transactional
    public List<Uloha> dostanCOtazku() {
        List<Uloha> ret = new LinkedList<>();
        for (UlohaCEntity u1 : ulohaCRepository.findAll()){
            Uloha u2 = mapCUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorCUlohu(Uloha uloha){
        UlohaCEntity ulohaCEntity = new UlohaCEntity();

        ulohaCEntity.setContent( uloha.getContent());
        ulohaCEntity.setInput(uloha.getInput());
        ulohaCEntity.setSolution(uloha.getSolution());

        this.ulohaCRepository.save(ulohaCEntity);
        return ulohaCEntity.getId();
    }

    @Transactional
    public Uloha dostanCOtazkuCezId(Long id) {
        for (UlohaCEntity u1 : ulohaCRepository.findAll()){
            if (u1.getId() == (id)) {
                return mapCUlohy(u1);
            }
        }
        return null;
    }

    public UlohaCEntity vytvorCUlohu(UlohaCEntity ulohaCEntity) {
        return ulohaCRepository.save(ulohaCEntity);
    }

    public UlohaCEntity dostanCOtazkuPodlaId(Long id) {
        return ulohaCRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public UlohaCEntity modifikujCOtazku(Long id, UlohaCEntity ulohaCEntity) {
        ulohaCEntity.setId(id);
        return ulohaCRepository.save(ulohaCEntity);
    }

    public void vymazCOtazku(Long id) {
        ulohaCRepository.deleteById(id);
    }

}