package com.example.java_labor_beadando;

import javax.persistence.*;

@Entity
public class Nezok {
    @Id
    public int id;
    private String nev;
    private boolean ferfi;
    private boolean belepes;

    public Nezok(int id, String nev, boolean ferfi, boolean belepes) {
        this.id = id;
        this.nev = nev;
        this.ferfi = ferfi;
        this.belepes = belepes;
    }

    public Nezok() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public boolean isFerfi() {
        return ferfi;
    }

    public void setFerfi(boolean ferfi) {
        this.ferfi = ferfi;
    }

    public boolean isBelepes() {
        return belepes;
    }

    public void setBelepes(boolean belepes) {
        this.belepes = belepes;
    }
}
