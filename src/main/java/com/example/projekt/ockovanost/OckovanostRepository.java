package com.example.projekt.ockovanost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OckovanostRepository extends JpaRepository<OckovanostEntity, Integer> {
    @Override
    List<OckovanostEntity> findAll();
    Optional<OckovanostEntity> findByDatum(String datum);
    Optional<OckovanostEntity> findById(int id);
}

