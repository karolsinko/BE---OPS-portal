package com.example.projekt.Quiz.Service;

import com.example.projekt.Quiz.Entity.QuizCEntity;
import com.example.projekt.Quiz.Model.Quiz;
import com.example.projekt.Quiz.Repository.QuizCRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuizCService {
    private final QuizCRepository quizCRepository;

    public QuizCService(QuizCRepository quizCRepository) {
        this.quizCRepository = quizCRepository;
    }

    public static Quiz mapQuizy(QuizCEntity quizCEntity) {
        Quiz quiz = new Quiz(quizCEntity.getId(), quizCEntity.getOption4(), quizCEntity.getQuestion(), quizCEntity.getOption1(), quizCEntity.getOption2(), quizCEntity.getOption3(), quizCEntity.getSolution());

        quiz.setId(quizCEntity.getId());
        quiz.setQuestion(quizCEntity.getQuestion());
        quiz.setOption1(quizCEntity.getOption1());
        quiz.setOption2(quizCEntity.getOption2());
        quiz.setOption3(quizCEntity.getOption3());
        quiz.setOption4(quizCEntity.getOption4());
        quiz.setSolution(quizCEntity.getSolution());

        return quiz;

    }

    @Transactional
    public List<Quiz> dostanQuiz() {
        List<Quiz> ret = new LinkedList<>();
        for (QuizCEntity q1 : quizCRepository.findAll()) {
            Quiz q2 = mapQuizy(q1);
            ret.add(q2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorQuiz(Quiz quiz) {
        QuizCEntity quizCEntity = new QuizCEntity();

        quizCEntity.setQuestion(quiz.getQuestion());
        quizCEntity.setOption1(quiz.getOption1());
        quizCEntity.setOption2(quiz.getOption2());
        quizCEntity.setOption3(quiz.getOption3());
        quizCEntity.setOption4(quiz.getOption4());
        quizCEntity.setSolution(quiz.getSolution());

        this.quizCRepository.save(quizCEntity);
        return quizCEntity.getId();
    }

    @Transactional
    public Quiz dostanQuizCezId(Long id) {
        for (QuizCEntity q1 : quizCRepository.findAll()) {
            if (q1.getId() == (id)) {
                return mapQuizy(q1);
            }
        }
        return null;
    }

    public QuizCEntity vytvorQuiz(QuizCEntity quizCEntity) {
        return quizCRepository.save(quizCEntity);
    }

    public QuizCEntity dostanQuizPodlaId(Long id) {
        return quizCRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz sa nenasiel"));
    }

    public QuizCEntity modifikujQuiz(Long id, QuizCEntity quizCEntity) {
        quizCEntity.setId(id);
        return quizCRepository.save(quizCEntity);
    }

    public void vymazQuiz(Long id) {
        quizCRepository.deleteById(id);
    }

}
