package com.example.projekt.Vakcina;

import com.example.projekt.Vakcina.VakcinaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VakcinaRepository extends CrudRepository<VakcinaEntity, Integer> {
    @Override
    List <VakcinaEntity> findAll();
    Optional<VakcinaEntity> findById(int id);
}

