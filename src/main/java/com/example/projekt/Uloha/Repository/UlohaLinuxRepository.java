package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaLinuxEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UlohaLinuxRepository extends CrudRepository<UlohaLinuxEntity, Long> {

    @Override
    List<UlohaLinuxEntity> findAll();
    Optional<UlohaLinuxEntity> findById(long id);
}
