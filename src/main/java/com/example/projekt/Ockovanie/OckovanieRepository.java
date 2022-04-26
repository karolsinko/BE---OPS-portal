package com.example.projekt.Ockovanie;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OckovanieRepository extends CrudRepository<OckovanieEntity, Integer> {
    @Override
    List<OckovanieEntity> findAll();
}
