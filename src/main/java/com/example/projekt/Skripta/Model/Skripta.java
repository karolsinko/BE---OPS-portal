package com.example.projekt.Skripta.Model;

public class Skripta {

    private Long id;
    private String content;
    private String content1;
    private String commands;
    private String explain;

    public Skripta(Long id, String content, String content1, String commands, String explain) {
        this.id = id;
        this.content = content;
        this.content1 = content1;
        this.commands = commands;
        this.explain = explain;
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

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

}
