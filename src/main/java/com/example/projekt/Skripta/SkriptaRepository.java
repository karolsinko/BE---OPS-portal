package com.example.projekt.Skripta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkriptaRepository extends CrudRepository<SkriptaEntity, Long> {

    @Override
    List<SkriptaEntity> findAll();
}
