package com.example.projekt.Quiz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuizService {


    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public static Quiz mapQuizy(QuizEntity quizEntity){
        Quiz quiz = new Quiz(quizEntity.getId(),quizEntity.getSolution(),quizEntity.getQuestion(),quizEntity.getOption1(),quizEntity.getOption2(),quizEntity.getOption3());

        quiz.setId(quizEntity.getId());
        quiz.setSolution(quizEntity.getSolution());
        quiz.setQuestion(quizEntity.getQuestion());
        quiz.setOption1(quizEntity.getOption1());
        quiz.setOption2(quizEntity.getOption2());
        quiz.setOption3(quizEntity.getOption3());
        return quiz;

    }

    @Transactional
    public List<Quiz> dostanQuizPodlaId() {
        List<Quiz> ret = new LinkedList<>();
        for (QuizEntity q1 : quizRepository.findAll()){
            Quiz q2 = mapQuizy(q1);
            ret.add(q2);
        }
        return ret;
    }

    public QuizEntity vytvorQuiz(QuizEntity quizEntity) {
        return quizRepository.save(quizEntity);
    }

    public QuizEntity dostanQuizPodlaId(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skript sa nenasiel"));
    }

    public QuizEntity modifikujQuiz(Long id, QuizEntity quizEntity) {
        quizEntity.setId(id);
        return quizRepository.save(quizEntity);
    }

    public void vymazQuiz(Long id) {
        quizRepository.deleteById(id);
    }

}
