package com.example.java_labor_beadando;

class MeccsekNotFoundException extends RuntimeException {
    MeccsekNotFoundException(Integer id) {
        super("A meccs nem található: " + id);
    }
}
