package com.example.projekt.Vakcina;

import javax.persistence.*;

@Entity
@Table(name = "VakcinaEntity")
public class VakcinaEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nazov", nullable = false)
    private String nazov;
    @Column(name = "pocet_davok", nullable = false)
    private int pocet_davok;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getPocetDavok() {
        return pocet_davok;
    }

    public void setPocetDavok(int pocet_davok) {
        this.pocet_davok = pocet_davok;
    }
}