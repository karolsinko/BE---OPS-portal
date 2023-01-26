package com.example.projekt.Uloha;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UlohaService {

    private final UlohaRepository ulohaRepository;

    public UlohaService(UlohaRepository ulohaRepository) {
        this.ulohaRepository = ulohaRepository;
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
