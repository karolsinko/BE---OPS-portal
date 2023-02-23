package com.example.projekt.Skripta.Entity;

import javax.persistence.*;

@Entity
@Table(name = "skripta_C")
public class SkriptaCEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false, length = 1024)
    private String content;

    @Column(name = "content1", nullable = false, length = 1024)
    private String content1;

    @Column(name = "commands", nullable = false, length = 1024)
    private String commands;

    @Column(name = "explain", nullable = false, length = 1024)
    private String explain;

    @Column(name = "scripts", nullable = false, length = 1024)
    private String scripts;

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

    public String getScripts() {
        return scripts;
    }

    public void setScripts(String scripts) {
        this.scripts = scripts;
    }
}
