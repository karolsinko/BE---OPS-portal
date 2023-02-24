package com.example.projekt.Skripta.Repository;

import com.example.projekt.Skripta.Entity.SkriptaLinuxEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkriptaLinuxRepository extends CrudRepository<SkriptaLinuxEntity, Long> {

    @Override
    List<SkriptaLinuxEntity> findAll();

    Optional<SkriptaLinuxEntity> findById(long id);
}
