package com.example.projekt.Quiz;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("api/quiz")
    public QuizEntity vytvorSkript(@RequestBody QuizEntity quizEntity) {
        return quizService.vytvorQuiz(quizEntity);
    }

    @GetMapping("/api/quiz")
    public List<Quiz> dostanQuiz(){
        return quizService.dostanQuiz();
    }

    @GetMapping("api/quiz/{id}")
    public QuizEntity dostanSkriptPodlaId(@PathVariable Long id) {
        return quizService.dostanQuizPodlaId(id);
    }

    @PutMapping("api/quiz/{id}")
    public QuizEntity modifikujSkript(@PathVariable Long id, @RequestBody QuizEntity quizEntity) {
        return quizService.modifikujQuiz(id, quizEntity);
    }

    @DeleteMapping("api/quiz/{id}")
    public void vymazSkript(@PathVariable Long id) {
        quizService.vymazQuiz(id);
    }
}
