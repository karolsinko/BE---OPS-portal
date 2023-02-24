package com.example.projekt.Quiz.Repository;

import com.example.projekt.Quiz.Entity.QuizLinuxEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizLinuxRepository extends CrudRepository<QuizLinuxEntity, Long> {

    @Override
    List<QuizLinuxEntity> findAll();

    Optional<QuizLinuxEntity> findById(long id);
}
