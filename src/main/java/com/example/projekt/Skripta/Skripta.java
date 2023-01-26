package com.example.projekt.Skripta;

public class Skripta {

    private Long id;
    private String content;
    private String content1;

    public Skripta(Long id, String content, String content1) {
        this.id = id;
        this.content = content;
        this.content1 = content1;
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

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }
}
