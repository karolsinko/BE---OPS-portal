package com.example.projekt.Uloha.Repository;

import com.example.projekt.Uloha.Entity.UlohaLinuxEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UlohaLinuxRepository extends CrudRepository<UlohaLinuxEntity, Long> {

    @Override
    List<UlohaLinuxEntity> findAll();
}
