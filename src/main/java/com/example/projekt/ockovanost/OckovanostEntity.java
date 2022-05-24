package com.example.projekt.ockovanost;

import com.example.projekt.osoba.OsobaEntity;
import com.example.projekt.vakcina.VakcinaEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class OckovanostEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "DATE")
    private LocalDate datum;

    @JoinColumn(name = "osoba_id")
    @ManyToOne
    private OsobaEntity osoba;

    @JoinColumn(name = "vakcina_id")
    @ManyToOne
    private VakcinaEntity vakcina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public OsobaEntity getOsoba() {
        return osoba;
    }

    public void setOsoba(OsobaEntity osoba) {
        this.osoba = osoba;
    }

    public VakcinaEntity getVakcina() {
        return vakcina;
    }

    public void setVakcina(VakcinaEntity vakcina) {
        this.vakcina = vakcina;
    }
}
