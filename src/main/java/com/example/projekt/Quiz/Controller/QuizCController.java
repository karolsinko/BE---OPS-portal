package com.example.projekt.Quiz.Controller;

import com.example.projekt.Quiz.Entity.QuizCEntity;
import com.example.projekt.Quiz.Model.Quiz;
import com.example.projekt.Quiz.Service.QuizCService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class QuizCController {
    private final QuizCService quizCService;

    public QuizCController(QuizCService quizCService) {
        this.quizCService = quizCService;
    }

    @PostMapping("api/quiz/c")
    public QuizCEntity vytvorQuiz(@RequestBody QuizCEntity quizCEntity) {
        return quizCService.vytvorQuiz(quizCEntity);
    }

    @GetMapping("/api/quiz/c")
    public List<Quiz> dostanQuiz(){
        List<Quiz> entities = quizCService.dostanQuiz();
        Collections.shuffle(entities);
        return entities;
    }

    @GetMapping("api/quiz/c/{id}")
    public QuizCEntity dostanQuizPodlaId(@PathVariable Long id) {
        return quizCService.dostanQuizPodlaId(id);
    }

    @PutMapping("api/quiz/c/{id}")
    public QuizCEntity modifikujQuiz(@PathVariable Long id, @RequestBody QuizCEntity quizCEntity) {
        return quizCService.modifikujQuiz(id, quizCEntity);
    }

    @DeleteMapping("api/quiz/c/{id}")
    public void vymazQuiz(@PathVariable Long id) {
        quizCService.vymazQuiz(id);
    }
}
