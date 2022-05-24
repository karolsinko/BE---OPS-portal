package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.OsobaEntity;
import com.example.projekt.Vakcina.VakcinaEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "OckovanieEntity")
public class OckovanieEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "osoba")
    private OsobaEntity osoba;
    @ManyToOne
    @JoinColumn(name = "vakcina")
    private VakcinaEntity vakcina;

    @Column(columnDefinition = "DATE")
    private LocalDate datum;

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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
