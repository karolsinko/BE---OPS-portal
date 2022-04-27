package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Osoba.OsobaEntity;
import com.example.projekt.Vakcina.Vakcina;
import com.example.projekt.Vakcina.VakcinaEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class OckovanieEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "osobaId")
    private OsobaEntity osoba;
    @ManyToOne
    @JoinColumn(name = "vakcinaId")
    private VakcinaEntity vakcina;
/*
    private String meno;
    private String priezvisko;
    private String rodCislo;
    private String nazov;
 */
    private Timestamp datumOckovania;

    public int getOckovanieId() {
        return id;
    }

    public void setOckovanieId(int id) {
        this.id = id;
    }

    public OsobaEntity getOsoba() {return osoba;}

    public void setOsoba(OsobaEntity osoba) {
        this.osoba = osoba;
    }

    public VakcinaEntity getVakcina() {
        return vakcina;
    }

    public void setVakcina(VakcinaEntity vakcina) {
        this.vakcina = vakcina;
    }
/*
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getRodCislo() {
        return rodCislo;
    }

    public void setRodCislo(String rodCislo) {
        this.rodCislo = rodCislo;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }
*/
    public Timestamp getDatumOckovania() {
        return datumOckovania;
    }

    public void setDatumOckovania(Timestamp datumOckovania) {
        this.datumOckovania = datumOckovania;
    }
}
