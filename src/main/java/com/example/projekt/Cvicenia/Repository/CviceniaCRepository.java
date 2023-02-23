package com.example.projekt.Cvicenia.Repository;

import com.example.projekt.Cvicenia.Entity.CviceniaCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CviceniaCRepository extends CrudRepository<CviceniaCEntity, Long> {

    @Override
    List<CviceniaCEntity> findAll();
    Optional<CviceniaCEntity> findById(long id);
 }
