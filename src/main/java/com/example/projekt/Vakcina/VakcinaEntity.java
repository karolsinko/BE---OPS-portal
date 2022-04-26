package com.example.projekt.Vakcina;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VakcinaEntity {
    @Id
    @GeneratedValue
    private int id;
    private String nazov;
    private int pocetDavok;

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
        return pocetDavok;
    }

    public void setPocetDavok(int pocetDavok) {
        this.pocetDavok = pocetDavok;
    }
}