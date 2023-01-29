package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaCEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UlohaCRepository extends CrudRepository<UlohaCEntity, Long> {

    @Override
    List<UlohaCEntity> findAll();
}
