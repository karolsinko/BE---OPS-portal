package com.example.projekt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VakcinaEntity {

    public String getNazov() {
        return nazov;
    }

    public int getPocet_davok() {
        return pocet_davok;
    }

    public int getId() {
        return id;
    }



    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public void setPocet_davok(int pocet_davok) {
        this.pocet_davok = pocet_davok;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Id
    @GeneratedValue
    private String nazov;
    private int pocet_davok;
    private int id;

}