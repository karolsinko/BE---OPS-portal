package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UlohaRepository extends CrudRepository<UlohaEntity, Long> {

    @Override
    List<UlohaEntity> findAll();
    Optional<UlohaEntity> findById(long id);
}
