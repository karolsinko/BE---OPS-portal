package com.example.projekt.Ockovanie;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Ockovanie {
    private int id;
    private int osobaId;
    private int vakcinaId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datum;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(int osobaId) {
        this.osobaId = osobaId;
    }

    public int getVakcinaId() {
        return vakcinaId;
    }

    public void setVakcinaId(int vakcinaId) {
        this.vakcinaId = vakcinaId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;

    }
}