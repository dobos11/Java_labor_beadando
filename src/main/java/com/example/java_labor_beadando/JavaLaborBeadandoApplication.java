package com.example.java_labor_beadando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JavaLaborBeadandoApplication {

    @Autowired
    private dataRepository dataRepository;
    private dataIIRepository dataIIRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaLaborBeadandoApplication.class, args);
    }

}
