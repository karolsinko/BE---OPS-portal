package com.example.projekt.Quiz;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("api/quiz")
    public QuizEntity vytvorQuiz(@RequestBody QuizEntity quizEntity) {
        return quizService.vytvorQuiz(quizEntity);
    }

    @GetMapping("/api/quiz")
    public List<Quiz> dostanQuiz(){
        List<Quiz> entities = quizService.dostanQuiz();
        Collections.shuffle(entities);
        return entities;
    }

    @GetMapping("api/quiz/{id}")
    public QuizEntity dostanQuizPodlaId(@PathVariable Long id) {
        return quizService.dostanQuizPodlaId(id);
    }

    @PutMapping("api/quiz/{id}")
    public QuizEntity modifikujQuiz(@PathVariable Long id, @RequestBody QuizEntity quizEntity) {
        return quizService.modifikujQuiz(id, quizEntity);
    }

    @DeleteMapping("api/quiz/{id}")
    public void vymazQuiz(@PathVariable Long id) {
        quizService.vymazQuiz(id);
    }
}
