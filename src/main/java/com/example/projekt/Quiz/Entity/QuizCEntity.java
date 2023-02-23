package com.example.projekt.Quiz.Entity;

import javax.persistence.*;

@Entity
@Table(name = "quiz_C")
public class QuizCEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "option1", nullable = false)
    private String option1;

    @Column(name = "option2", nullable = false)
    private String option2;

    @Column(name = "option3", nullable = false)
    private String option3;

    @Column(name = "option4", nullable = false)
    private String option4;

    @Column(name = "solution", nullable = false)
    private String solution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
