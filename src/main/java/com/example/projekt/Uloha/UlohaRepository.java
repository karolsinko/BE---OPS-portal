package com.example.projekt.Uloha;
import com.example.projekt.Skripta.SkriptaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UlohaRepository extends CrudRepository<UlohaEntity, Long> {

    @Override
    List<UlohaEntity> findAll();
}
