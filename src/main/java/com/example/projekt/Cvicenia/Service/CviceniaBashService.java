package com.example.projekt.Cvicenia.Service;

import com.example.projekt.Cvicenia.Entity.CviceniaBashEntity;
import com.example.projekt.Cvicenia.Model.Cvicenia;
import com.example.projekt.Cvicenia.Repository.CviceniaBashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CviceniaBashService {

    private final CviceniaBashRepository ulohaBashRepository;

    @Autowired
    public CviceniaBashService(CviceniaBashRepository ulohaBashRepository) {
        this.ulohaBashRepository = ulohaBashRepository;
    }

    //Service pre C otazky vseobecne
    public static Cvicenia mapBashUlohy(CviceniaBashEntity ulohaBashEntity){
        Cvicenia uloha = new Cvicenia(ulohaBashEntity.getId(), ulohaBashEntity.getContent(), ulohaBashEntity.getInput(), ulohaBashEntity.getSolution());

        uloha.setId(ulohaBashEntity.getId());
        uloha.setContent(ulohaBashEntity.getContent());
        uloha.setInput(ulohaBashEntity.getInput());
        uloha.setSolution(ulohaBashEntity.getSolution());

        return uloha;

    }

    @Transactional
    public List<Cvicenia> dostanBashOtazku() {
        List<Cvicenia> ret = new LinkedList<>();
        for (CviceniaBashEntity u1 : ulohaBashRepository.findAll()){
            Cvicenia u2 = mapBashUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorBashUlohu(Cvicenia uloha){
        CviceniaBashEntity ulohaBashEntity = new CviceniaBashEntity();

        ulohaBashEntity.setContent( uloha.getContent());
        ulohaBashEntity.setInput(uloha.getInput());
        ulohaBashEntity.setSolution(uloha.getSolution());

        this.ulohaBashRepository.save(ulohaBashEntity);
        return ulohaBashEntity.getId();
    }

    @Transactional
    public Cvicenia dostanBashOtazkuCezId(Long id) {
        for (CviceniaBashEntity u1 : ulohaBashRepository.findAll()){
            if (u1.getId() == (id)) {
                return mapBashUlohy(u1);
            }
        }
        return null;
    }

    public CviceniaBashEntity vytvorBashUlohu(CviceniaBashEntity ulohaBashEntity) {
        return ulohaBashRepository.save(ulohaBashEntity);
    }

    public CviceniaBashEntity dostanBashOtazkuPodlaId(Long id) {
        return ulohaBashRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public CviceniaBashEntity modifikujBashOtazku(Long id, CviceniaBashEntity ulohaBashEntity) {
        ulohaBashEntity.setId(id);
        return ulohaBashRepository.save(ulohaBashEntity);
    }

    public void vymazBashOtazku(Long id) {
        ulohaBashRepository.deleteById(id);
    }
}
