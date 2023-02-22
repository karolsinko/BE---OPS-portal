package com.example.projekt.Quiz.Repository;

import com.example.projekt.Quiz.Entity.QuizBashEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizBashRepository extends CrudRepository<QuizBashEntity, Long> {
    @Override
    List<QuizBashEntity> findAll();
    Optional<QuizBashEntity> findById(long id);
}
