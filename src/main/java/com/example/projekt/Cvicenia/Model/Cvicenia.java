package com.example.projekt.Cvicenia.Model;

public class Cvicenia {

    private Long id;
    private String content;
    private String input;
    private String solution;

    public Cvicenia(Long id, String content, String input, String solution) {
        this.id = id;
        this.content = content;
        this.input = input;
        this.solution = solution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
