package com.example.projekt.Quiz.Repository;

import com.example.projekt.Quiz.Entity.QuizCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizCRepository extends CrudRepository<QuizCEntity, Long> {
    @Override
    List<QuizCEntity> findAll();
    Optional<QuizCEntity> findById(long id);
}
