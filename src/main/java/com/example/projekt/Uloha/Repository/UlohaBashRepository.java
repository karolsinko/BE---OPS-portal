package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaBashEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UlohaBashRepository extends CrudRepository<UlohaBashEntity,Long> {

    @Override
    List<UlohaBashEntity> findAll();
    Optional<UlohaBashEntity> findById(long id);
}
