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
        Quiz quiz = new Quiz(quizEntity.getId(),quizEntity.getOption4(),quizEntity.getQuestion(),quizEntity.getOption1(),quizEntity.getOption2(),quizEntity.getOption3(), quizEntity.getSolution());

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
        for (QuizEntity q1 : quizRepository.findAll()){
            Quiz q2 = mapQuizy(q1);
            ret.add(q2);
        }
        return ret;
    }

    @Transactional
    public Long vytvorQuiz(Quiz quiz){
        QuizEntity quizEntity = new QuizEntity();

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
        for (QuizEntity q1 : quizRepository.findAll()){
            if (q1.getId() == (id)) {
                return mapQuizy(q1);
            }
        }
        return null;
    }

    public QuizEntity vytvorQuiz(QuizEntity quizEntity) {
        return quizRepository.save(quizEntity);
    }

    public QuizEntity dostanQuizPodlaId(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz sa nenasiel"));
    }

    public QuizEntity modifikujQuiz(Long id, QuizEntity quizEntity) {
        quizEntity.setId(id);
        return quizRepository.save(quizEntity);
    }

    public void vymazQuiz(Long id) {
        quizRepository.deleteById(id);
    }

}
