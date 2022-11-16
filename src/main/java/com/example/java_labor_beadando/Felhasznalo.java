package com.example.java_labor_beadando;

enum Jogosultság{
    ADMIN,
    USER,
    LATOGATO
}

public class Felhasznalo {
    private String név;
    private String Jelszó;
    private Jogosultság jogosultság;

    public Felhasznalo() {
    }

    public Felhasznalo(String név, String jelszó, Jogosultság jogosultság) {
        this.név = név;
        Jelszó = jelszó;
        this.jogosultság = jogosultság;
    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public String getJelszó() {
        return Jelszó;
    }

    public void setJelszó(String jelszó) {
        Jelszó = jelszó;
    }

    public Jogosultság getJogosultság() {
        return jogosultság;
    }

    public void setJogosultság(Jogosultság jogosultság) {
        this.jogosultság = jogosultság;
    }
}
