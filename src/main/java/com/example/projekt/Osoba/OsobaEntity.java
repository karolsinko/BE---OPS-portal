package com.example.projekt.Osoba;

import javax.persistence.*;

@Entity
@Table(name = "OsobaEntity")
public class OsobaEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "meno", nullable = false)
    private String meno;
    @Column(name = "priezvisko", nullable = false)
    private String priezvisko;
    @Column(name = "rokNar", nullable = false)
    private String rokNar;
    @Column(name = "rodCislo", nullable = false)
    private String rodCislo;
    @Column(name = "bydlisko", nullable = false)
    private String bydlisko;
    @Column(name = "pohlavie", nullable = false)
    private String pohlavie;
    @Column(name = "telCislo", nullable = false)
    private String telCislo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getRokNar() {
        return rokNar;
    }

    public void setRokNar(String rokNar) {
        this.rokNar = rokNar;
    }

    public String getRodCislo() {
        return rodCislo;
    }

    public void setRodCislo(String rodCislo) {
        this.rodCislo = rodCislo;
    }

    public String getBydlisko() {
        return bydlisko;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }

    public String getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(String pohlavie) {
        this.pohlavie = pohlavie;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public void setTelCislo(String telCislo) {
        this.telCislo = telCislo;
    }
}