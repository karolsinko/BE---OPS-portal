package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Vakcina.Vakcina;

import java.sql.Timestamp;

public class Ockovanie {
    private int id;
    private Osoba osoba;
    private Vakcina vakcina;

    private Timestamp datum_ockovania;

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

    public Timestamp getDatumOckovania() {  return datum_ockovania;}
    public void setDatumOckovania(Timestamp datum_ockovania) {this.datum_ockovania = datum_ockovania;}


}