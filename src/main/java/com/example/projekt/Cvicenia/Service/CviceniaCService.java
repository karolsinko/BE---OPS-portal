package com.example.projekt.Cvicenia.Service;

import com.example.projekt.Cvicenia.Entity.CviceniaCEntity;
import com.example.projekt.Cvicenia.Model.Cvicenia;
import com.example.projekt.Cvicenia.Repository.CviceniaCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CviceniaCService {

    private final CviceniaCRepository ulohaCRepository;

    @Autowired
    public CviceniaCService(CviceniaCRepository ulohaCRepository) {
        this.ulohaCRepository = ulohaCRepository;
    }

    //Service pre C otazky vseobecne
    public static Cvicenia mapCUlohy(CviceniaCEntity ulohaCEntity) {
        Cvicenia uloha = new Cvicenia(ulohaCEntity.getId(), ulohaCEntity.getContent(), ulohaCEntity.getInput(), ulohaCEntity.getSolution());

        uloha.setId(ulohaCEntity.getId());
        uloha.setContent(ulohaCEntity.getContent());
        uloha.setInput(ulohaCEntity.getInput());
        uloha.setSolution(ulohaCEntity.getSolution());

        return uloha;

    }

    @Transactional
    public List<Cvicenia> dostanCOtazku() {
        List<Cvicenia> ret = new LinkedList<>();
        for (CviceniaCEntity u1 : ulohaCRepository.findAll()) {
            Cvicenia u2 = mapCUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorCUlohu(Cvicenia uloha) {
        CviceniaCEntity ulohaCEntity = new CviceniaCEntity();

        ulohaCEntity.setContent(uloha.getContent());
        ulohaCEntity.setInput(uloha.getInput());
        ulohaCEntity.setSolution(uloha.getSolution());

        this.ulohaCRepository.save(ulohaCEntity);
        return ulohaCEntity.getId();
    }

    @Transactional
    public Cvicenia dostanCOtazkuCezId(Long id) {
        for (CviceniaCEntity u1 : ulohaCRepository.findAll()) {
            if (u1.getId() == (id)) {
                return mapCUlohy(u1);
            }
        }
        return null;
    }

    public CviceniaCEntity vytvorCUlohu(CviceniaCEntity ulohaCEntity) {
        return ulohaCRepository.save(ulohaCEntity);
    }

    public CviceniaCEntity dostanCOtazkuPodlaId(Long id) {
        return ulohaCRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public CviceniaCEntity modifikujCOtazku(Long id, CviceniaCEntity ulohaCEntity) {
        ulohaCEntity.setId(id);
        return ulohaCRepository.save(ulohaCEntity);
    }

    public void vymazCOtazku(Long id) {
        ulohaCRepository.deleteById(id);
    }

}