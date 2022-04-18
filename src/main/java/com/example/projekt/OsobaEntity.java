package com.example.projekt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OsobaEntity {
    @Id
    @GeneratedValue
    private int id;
    private String meno;
    private String priezvisko;
    private String rok_nar;
    private String rod_cislo;
    private String bydlisko;
    private String pohlavie;
    private String tel_cislo;

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

    public String getRok_nar() {
        return rok_nar;
    }

    public void setRok_nar(String rok_nar) {
        this.rok_nar = rok_nar;
    }

    public String getRod_cislo() {
        return rod_cislo;
    }

    public void setRod_cislo(String rod_cislo) {
        this.rod_cislo = rod_cislo;
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

    public String getTel_cislo() {
        return tel_cislo;
    }

    public void setTel_cislo(String tel_cislo) {
        this.tel_cislo = tel_cislo;
    }
}