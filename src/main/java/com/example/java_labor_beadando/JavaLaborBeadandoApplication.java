package com.example.java_labor_beadando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JavaLaborBeadandoApplication {

    @Autowired
    private com.example.java_labor_beadando.repositories.dataRepository dataRepository;
    @Autowired
    private com.example.java_labor_beadando.repositories.dataIIRepository dataIIRepository;
    @Autowired
    private com.example.java_labor_beadando.repositories.dataIIIRepository dataIIIRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaLaborBeadandoApplication.class, args);
    }

}
