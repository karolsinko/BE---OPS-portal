package com.example.projekt.Quiz;

public class Quiz {

    private Long id;
    private String solution;
    private String option1;
    private String option2;
    private String option3;
    private String question;

    public Quiz(Long id, String solution, String option1, String option2, String option3, String question) {
        this.id = id;
        this.solution = solution;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
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
}
