package com.example.projekt.ockovanost;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Ockovanost {

    private String menoOsoba;
    private String nazovVakcina;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datum;


    public String getMenoOsoba() {
        return menoOsoba;
    }

    public void setMenoOsoba(String menoOsoba) {
        this.menoOsoba = menoOsoba;
    }

    public String getNazovVakcina() {
        return nazovVakcina;
    }

    public void setNazovVakcina(String nazovVakcina) {
        this.nazovVakcina = nazovVakcina;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
