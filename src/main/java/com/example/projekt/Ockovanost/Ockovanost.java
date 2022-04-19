package com.example.projekt.Ockovanost;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Vakcina.Vakcina;

public class Ockovanost {
    private int id;
    private String datum;
    private Osoba osoba;
    private Vakcina vakcina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public Vakcina getVakcina() {
        return vakcina;
    }

    public void setVakcina(Vakcina vakcina) {
        this.vakcina = vakcina;
    }
}
