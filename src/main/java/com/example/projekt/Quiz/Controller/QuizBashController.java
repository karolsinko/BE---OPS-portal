package com.example.projekt.Quiz.Controller;

import com.example.projekt.Quiz.Entity.QuizBashEntity;
import com.example.projekt.Quiz.Model.Quiz;
import com.example.projekt.Quiz.Service.QuizBashService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class QuizBashController {
    private final QuizBashService quizBashService;

    public QuizBashController(QuizBashService quizBashService) {
        this.quizBashService = quizBashService;
    }

    @PostMapping("api/quiz/bash")
    public QuizBashEntity vytvorQuiz(@RequestBody QuizBashEntity quizBashEntity) {
        return quizBashService.vytvorQuiz(quizBashEntity);
    }

    @GetMapping("/api/quiz/bash")
    public List<Quiz> dostanQuiz(){
        List<Quiz> entities = quizBashService.dostanQuiz();
        Collections.shuffle(entities);
        return entities;
    }

    @GetMapping("api/quiz/bash/{id}")
    public QuizBashEntity dostanQuizPodlaId(@PathVariable Long id) {
        return quizBashService.dostanQuizPodlaId(id);
    }

    @PutMapping("api/quiz/bash/{id}")
    public QuizBashEntity modifikujQuiz(@PathVariable Long id, @RequestBody QuizBashEntity quizBashEntity) {
        return quizBashService.modifikujQuiz(id, quizBashEntity);
    }

    @DeleteMapping("api/quiz/bash/{id}")
    public void vymazQuiz(@PathVariable Long id) {
        quizBashService.vymazQuiz(id);
    }
}
