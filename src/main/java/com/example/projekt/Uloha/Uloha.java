package com.example.projekt.Uloha;

public class Uloha {

    private Long id;
    private String content;
    private String input;
    private String solution;
    private String language;

    public Uloha(Long id, String content, String input, String solution, String language) {
        this.id = id;
        this.content = content;
        this.input = input;
        this.solution = solution;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
