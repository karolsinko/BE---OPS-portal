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
    @Column(name = "rok_nar", nullable = false)
    private String rok_nar;
    @Column(name = "rod_cislo", nullable = false)
    private String rod_cislo;
    @Column(name = "bydlisko", nullable = false)
    private String bydlisko;
    @Column(name = "tel_cislo", nullable = false)
    private String tel_cislo;
    @Column(name = "pohlavie", nullable = false)
    private String pohlavie;


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
        return rok_nar;
    }

    public void setRokNar(String rokNar) {
        this.rok_nar = rokNar;
    }

    public String getRodCislo() {
        return rod_cislo;
    }

    public void setRodCislo(String rod_cislo) {
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

    public String getTelCislo() {
        return tel_cislo;
    }

    public void setTelCislo(String tel_cislo) {
        this.tel_cislo = tel_cislo;
    }
}