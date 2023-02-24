package com.example.projekt.Cvicenia.Repository;

import com.example.projekt.Cvicenia.Entity.CviceniaLinuxEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CviceniaLinuxRepository extends CrudRepository<CviceniaLinuxEntity, Long> {

    @Override
    List<CviceniaLinuxEntity> findAll();

    Optional<CviceniaLinuxEntity> findById(long id);
}
