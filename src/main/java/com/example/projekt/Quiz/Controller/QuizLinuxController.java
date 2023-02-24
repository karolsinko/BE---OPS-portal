package com.example.projekt.Quiz.Controller;

import com.example.projekt.Quiz.Entity.QuizLinuxEntity;
import com.example.projekt.Quiz.Model.Quiz;
import com.example.projekt.Quiz.Service.QuizLinuxService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class QuizLinuxController {
    private final QuizLinuxService quizService;

    public QuizLinuxController(QuizLinuxService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("api/quiz/linux")
    public QuizLinuxEntity vytvorQuiz(@RequestBody QuizLinuxEntity quizEntity) {
        return quizService.vytvorQuiz(quizEntity);
    }

    @GetMapping("/api/quiz/linux")
    public List<Quiz> dostanQuiz() {
        List<Quiz> entities = quizService.dostanQuiz();
        Collections.shuffle(entities);
        return entities;
    }

    @GetMapping("api/quiz/linux/{id}")
    public QuizLinuxEntity dostanQuizPodlaId(@PathVariable Long id) {
        return quizService.dostanQuizPodlaId(id);
    }

    @PutMapping("api/quiz/linux/{id}")
    public QuizLinuxEntity modifikujQuiz(@PathVariable Long id, @RequestBody QuizLinuxEntity quizEntity) {
        return quizService.modifikujQuiz(id, quizEntity);
    }

    @DeleteMapping("api/quiz/linux/{id}")
    public void vymazQuiz(@PathVariable Long id) {
        quizService.vymazQuiz(id);
    }
}
