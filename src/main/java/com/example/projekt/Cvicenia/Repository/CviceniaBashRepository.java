package com.example.projekt.Cvicenia.Repository;

import com.example.projekt.Cvicenia.Entity.CviceniaBashEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CviceniaBashRepository extends CrudRepository<CviceniaBashEntity,Long> {

    @Override
    List<CviceniaBashEntity> findAll();
    Optional<CviceniaBashEntity> findById(long id);
}
