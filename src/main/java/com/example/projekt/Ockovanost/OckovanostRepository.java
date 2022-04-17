package com.example.projekt.Ockovanost;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OckovanostRepository extends CrudRepository<OckovanostEntity, Integer> {
    @Override
    List<OckovanostService> findAll();
    Optional<OckovanostEntity> findById(int id);
}
