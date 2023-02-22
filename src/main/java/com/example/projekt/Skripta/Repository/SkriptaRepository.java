package com.example.projekt.Skripta.Repository;

import com.example.projekt.Skripta.Entity.SkriptaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkriptaRepository extends CrudRepository<SkriptaEntity, Long> {

    @Override
    List<SkriptaEntity> findAll();
    Optional<SkriptaEntity> findById(long id);
}
