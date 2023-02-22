package com.example.projekt.Skripta.Repository;

import com.example.projekt.Skripta.Entity.SkriptaCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkriptaCRepository extends CrudRepository<SkriptaCEntity, Long> {

    @Override
    List<SkriptaCEntity> findAll();
    Optional<SkriptaCEntity> findById(long id);
}
