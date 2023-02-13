package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UlohaCRepository extends CrudRepository<UlohaCEntity, Long> {

    @Override
    List<UlohaCEntity> findAll();
    Optional<UlohaCEntity> findById(long id);
 }
