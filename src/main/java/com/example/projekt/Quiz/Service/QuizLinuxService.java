package com.example.projekt.Quiz.Service;

import com.example.projekt.Quiz.Entity.QuizLinuxEntity;
import com.example.projekt.Quiz.Model.Quiz;
import com.example.projekt.Quiz.Repository.QuizLinuxRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuizLinuxService {


    private final QuizLinuxRepository quizRepository;

    public QuizLinuxService(QuizLinuxRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public static Quiz mapQuizy(QuizLinuxEntity quizEntity) {
        Quiz quiz = new Quiz(quizEntity.getId(), quizEntity.getOption4(), quizEntity.getQuestion(), quizEntity.getOption1(), quizEntity.getOption2(), quizEntity.getOption3(), quizEntity.getSolution());

        quiz.setId(quizEntity.getId());
        quiz.setQuestion(quizEntity.getQuestion());
        quiz.setOption1(quizEntity.getOption1());
        quiz.setOption2(quizEntity.getOption2());
        quiz.setOption3(quizEntity.getOption3());
        quiz.setOption4(quizEntity.getOption4());
        quiz.setSolution(quizEntity.getSolution());

        return quiz;

    }

    @Transactional
    public List<Quiz> dostanQuiz() {
        List<Quiz> ret = new LinkedList<>();
        for (QuizLinuxEntity q1 : quizRepository.findAll()) {
            Quiz q2 = mapQuizy(q1);
            ret.add(q2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorQuiz(Quiz quiz) {
        QuizLinuxEntity quizEntity = new QuizLinuxEntity();

        quizEntity.setQuestion(quiz.getQuestion());
        quizEntity.setOption1(quiz.getOption1());
        quizEntity.setOption2(quiz.getOption2());
        quizEntity.setOption3(quiz.getOption3());
        quizEntity.setOption4(quiz.getOption4());
        quizEntity.setSolution(quiz.getSolution());

        this.quizRepository.save(quizEntity);
        return quizEntity.getId();
    }

    @Transactional
    public Quiz dostanQuizCezId(Long id) {
        for (QuizLinuxEntity q1 : quizRepository.findAll()) {
            if (q1.getId() == (id)) {
                return mapQuizy(q1);
            }
        }
        return null;
    }

    public QuizLinuxEntity vytvorQuiz(QuizLinuxEntity quizEntity) {
        return quizRepository.save(quizEntity);
    }

    public QuizLinuxEntity dostanQuizPodlaId(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz sa nenasiel"));
    }

    public QuizLinuxEntity modifikujQuiz(Long id, QuizLinuxEntity quizEntity) {
        quizEntity.setId(id);
        return quizRepository.save(quizEntity);
    }

    public void vymazQuiz(Long id) {
        quizRepository.deleteById(id);
    }

}
