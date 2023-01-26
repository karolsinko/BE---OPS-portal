package com.example.projekt.Uloha;
import javax.persistence.*;

@Entity
@Table(name = "cvicenia")
public class UlohaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "content", nullable = false)
        private String content;

        @Column(name = "input", nullable = false)
        private String input;

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
