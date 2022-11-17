package com.example.java_labor_beadando;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meccsek {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String datum;
    private String kezdes;
    private int tipus;
    private int belepo;

    public Meccsek(int id, String datum, String kezdes, int tipus, int belepo) {
        this.id = id;
        this.datum = datum;
        this.kezdes = kezdes;
        this.tipus = tipus;
        this.belepo = belepo;
    }

    public Meccsek() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKezdes() {
        return kezdes;
    }

    public void setKezdes(String kezdes) {
        this.kezdes = kezdes;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public int getBelepo() {
        return belepo;
    }

    public void setBelepo(int belepo) {
        this.belepo = belepo;
    }
}


