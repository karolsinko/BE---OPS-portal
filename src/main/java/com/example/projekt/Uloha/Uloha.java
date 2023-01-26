package com.example.projekt.Uloha;

public class Uloha {

    private Long id;
    private String content;
    private String input;

    public Uloha(Long id, String content, String input) {
        this.id = id;
        this.content = content;
        this.input = input;
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
}
