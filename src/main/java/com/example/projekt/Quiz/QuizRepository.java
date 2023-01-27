package com.example.projekt.Quiz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends CrudRepository<QuizEntity, Long> {

    @Override
    List<QuizEntity> findAll();
    Optional<QuizEntity> findById(long id);
}
