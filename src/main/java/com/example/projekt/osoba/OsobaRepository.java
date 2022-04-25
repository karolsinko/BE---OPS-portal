package com.example.projekt.osoba;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsobaRepository extends CrudRepository<OsobaEntity, Integer> {
    @Override
    List<OsobaEntity> findAll();
    Optional<OsobaEntity> findByPriezvisko(String priezvisko);
    Optional<OsobaEntity> findById(int id);
}

