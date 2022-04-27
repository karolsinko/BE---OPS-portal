package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Vakcina.Vakcina;

import java.sql.Timestamp;

public class Ockovanie {
    private int id;
    private Osoba osoba;
    private Vakcina vakcina;
    private int osobaId;
    private int vakcinaId;

    private Timestamp datumOckovania;

    public int getOckovanieId(){return id;}
    public void setOckovanieId(int id){this.id=id;}

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

    public int getOsobaId() {return osobaId;}
    public void setOsobaId(int osobaId) {this.osobaId = osobaId;    }

    public int getVakcinaId() {return vakcinaId;}
    public void setVakcinaId(int vakcinaId) {this.vakcinaId = vakcinaId;}
}