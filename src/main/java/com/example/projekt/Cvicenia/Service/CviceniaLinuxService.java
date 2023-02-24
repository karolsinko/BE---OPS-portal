package com.example.projekt.Cvicenia.Service;

import com.example.projekt.Cvicenia.Entity.CviceniaLinuxEntity;
import com.example.projekt.Cvicenia.Model.Cvicenia;
import com.example.projekt.Cvicenia.Repository.CviceniaLinuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CviceniaLinuxService {

    private final CviceniaLinuxRepository ulohaLinuxRepository;

    @Autowired
    public CviceniaLinuxService(CviceniaLinuxRepository ulohaLinuxRepository) {
        this.ulohaLinuxRepository = ulohaLinuxRepository;
    }

    //Service pre Linux otazky vseobecne
    public static Cvicenia mapLinuxUlohy(CviceniaLinuxEntity ulohaLinuxEntity) {
        Cvicenia uloha = new Cvicenia(ulohaLinuxEntity.getId(), ulohaLinuxEntity.getContent(), ulohaLinuxEntity.getInput(), ulohaLinuxEntity.getSolution());

        uloha.setId(ulohaLinuxEntity.getId());
        uloha.setContent(ulohaLinuxEntity.getContent());
        uloha.setInput(ulohaLinuxEntity.getInput());
        uloha.setSolution(ulohaLinuxEntity.getSolution());

        return uloha;

    }

    @Transactional
    public List<Cvicenia> dostanLinuxOtazku() {
        List<Cvicenia> ret = new LinkedList<>();
        for (CviceniaLinuxEntity u1 : ulohaLinuxRepository.findAll()) {
            Cvicenia u2 = mapLinuxUlohy(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorLinuxUlohu(Cvicenia uloha) {
        CviceniaLinuxEntity ulohaLinuxEntity = new CviceniaLinuxEntity();

        ulohaLinuxEntity.setContent(uloha.getContent());
        ulohaLinuxEntity.setInput(uloha.getInput());
        ulohaLinuxEntity.setSolution(uloha.getSolution());

        this.ulohaLinuxRepository.save(ulohaLinuxEntity);
        return ulohaLinuxEntity.getId();
    }

    @Transactional
    public Cvicenia dostanLinuxOtazkuCezId(Long id) {
        for (CviceniaLinuxEntity u1 : ulohaLinuxRepository.findAll()) {
            if (u1.getId() == (id)) {
                return mapLinuxUlohy(u1);
            }
        }
        return null;
    }

    public CviceniaLinuxEntity vytvorLinuxUlohu(CviceniaLinuxEntity ulohaLinuxEntity) {
        return ulohaLinuxRepository.save(ulohaLinuxEntity);
    }

    public CviceniaLinuxEntity dostanLinuxOtazkuPodlaId(Long id) {
        return ulohaLinuxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Uloha sa nenasla"));
    }

    public CviceniaLinuxEntity modifikujLinuxOtazku(Long id, CviceniaLinuxEntity ulohaLinuxEntity) {
        ulohaLinuxEntity.setId(id);
        return ulohaLinuxRepository.save(ulohaLinuxEntity);
    }

    public void vymazCOtazku(Long id) {
        ulohaLinuxRepository.deleteById(id);
    }

}
