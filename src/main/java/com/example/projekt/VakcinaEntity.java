package com.example.projekt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VakcinaEntity {
    @Id
    @GeneratedValue
    private int id;
    private String nazov;
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

    public int getPocet_davok() {
        return pocet_davok;
    }

    public void setPocet_davok(int pocet_davok) {
        this.pocet_davok = pocet_davok;
    }
}