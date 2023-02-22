package com.example.projekt.Skripta.Repository;

import com.example.projekt.Skripta.Entity.SkriptaBashEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkriptaBashRepository extends CrudRepository<SkriptaBashEntity, Long> {

    @Override
    List<SkriptaBashEntity> findAll();
    Optional<SkriptaBashEntity> findById(long id);
}
