package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaBashEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UlohaBashRepository extends CrudRepository<UlohaBashEntity,Long> {

    @Override
    List<UlohaBashEntity> findAll();
}
