package com.example.projekt.Quiz.Service;

import com.example.projekt.Quiz.Entity.QuizBashEntity;
import com.example.projekt.Quiz.Model.Quiz;
import com.example.projekt.Quiz.Repository.QuizBashRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuizBashService {
    private final QuizBashRepository quizBashRepository;

    public QuizBashService(QuizBashRepository quizBashRepository) {
        this.quizBashRepository = quizBashRepository;
    }

    public static Quiz mapQuizy(QuizBashEntity quizBashEntity) {
        Quiz quiz = new Quiz(quizBashEntity.getId(), quizBashEntity.getOption4(), quizBashEntity.getQuestion(), quizBashEntity.getOption1(), quizBashEntity.getOption2(), quizBashEntity.getOption3(), quizBashEntity.getSolution());

        quiz.setId(quizBashEntity.getId());
        quiz.setQuestion(quizBashEntity.getQuestion());
        quiz.setOption1(quizBashEntity.getOption1());
        quiz.setOption2(quizBashEntity.getOption2());
        quiz.setOption3(quizBashEntity.getOption3());
        quiz.setOption4(quizBashEntity.getOption4());
        quiz.setSolution(quizBashEntity.getSolution());

        return quiz;

    }

    @Transactional
    public List<Quiz> dostanQuiz() {
        List<Quiz> ret = new LinkedList<>();
        for (QuizBashEntity q1 : quizBashRepository.findAll()) {
            Quiz q2 = mapQuizy(q1);
            ret.add(q2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorQuiz(Quiz quiz) {
        QuizBashEntity quizBashEntity = new QuizBashEntity();

        quizBashEntity.setQuestion(quiz.getQuestion());
        quizBashEntity.setOption1(quiz.getOption1());
        quizBashEntity.setOption2(quiz.getOption2());
        quizBashEntity.setOption3(quiz.getOption3());
        quizBashEntity.setOption4(quiz.getOption4());
        quizBashEntity.setSolution(quiz.getSolution());

        this.quizBashRepository.save(quizBashEntity);
        return quizBashEntity.getId();
    }

    @Transactional
    public Quiz dostanQuizCezId(Long id) {
        for (QuizBashEntity q1 : quizBashRepository.findAll()) {
            if (q1.getId() == (id)) {
                return mapQuizy(q1);
            }
        }
        return null;
    }

    public QuizBashEntity vytvorQuiz(QuizBashEntity quizBashEntity) {
        return quizBashRepository.save(quizBashEntity);
    }

    public QuizBashEntity dostanQuizPodlaId(Long id) {
        return quizBashRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz sa nenasiel"));
    }

    public QuizBashEntity modifikujQuiz(Long id, QuizBashEntity quizBashEntity) {
        quizBashEntity.setId(id);
        return quizBashRepository.save(quizBashEntity);
    }

    public void vymazQuiz(Long id) {
        quizBashRepository.deleteById(id);
    }
}
