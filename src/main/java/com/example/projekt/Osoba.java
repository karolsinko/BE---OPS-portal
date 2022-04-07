package com.example.projekt;

public class Osoba {

    private String meno;
    private String priezvisko;
    private String rok_nar;
    private String rod_cislo;
    private int id;
    private String bydlisko;
    private String pohlavie;
    private String tel_cislo;

    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public String getRok_Nar() {
        return rok_nar;
    }

    public String getRod_Cislo() {
        return rod_cislo;
    }

    public int getId() {
        return id;
    }

    public String getTel_cislo() {
        return tel_cislo;
    }

    public String getBydlisko() {
        return bydlisko;
    }

    public String getPohlavie() {
        return pohlavie;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public void setRok_Nar(String rok_nar) {
        this.rok_nar = rok_nar;
    }

    public void setRod_Cislo(String rod_cislo) {
        this.rod_cislo = rod_cislo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }

    public void setPohlavie(String pohlavie) {
        this.pohlavie = pohlavie;
    }

    public void setTel_cislo(String tel_cislo) {
        this.tel_cislo = tel_cislo;
    }
}


