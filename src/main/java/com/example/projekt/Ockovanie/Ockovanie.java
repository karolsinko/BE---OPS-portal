package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Vakcina.Vakcina;

import java.sql.Date;
import java.sql.Timestamp;

public class Ockovanie {
    private int id;
    private Osoba osoba;
    private Vakcina vakcina;

    private Timestamp datumOckovania;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public Osoba getOsoba() {
        return osoba;
    }
    public void setOsoba(Osoba osoba) {this.osoba = osoba;}

    public Vakcina getVakcina() {
        return vakcina;
    }
    public void setVakcina(Vakcina vakcina) {this.vakcina = vakcina;}

    public Timestamp getDatumOckovania() {  return datumOckovania;}
    public void setDatumOckovania(Timestamp datumOckovania) {this.datumOckovania = datumOckovania;}


}