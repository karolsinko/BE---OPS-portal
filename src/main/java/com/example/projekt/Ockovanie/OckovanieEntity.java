package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Osoba.OsobaEntity;
import com.example.projekt.Vakcina.Vakcina;
import com.example.projekt.Vakcina.VakcinaEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "OckovanieEntity")
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

    public Timestamp getDatumOckovania() {
        return datumOckovania;
    }

    public void setDatumOckovania(Timestamp datumOckovania) {
        this.datumOckovania = datumOckovania;
    }
}
