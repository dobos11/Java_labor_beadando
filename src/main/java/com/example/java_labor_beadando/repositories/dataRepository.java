package com.example.java_labor_beadando.repositories;

import com.example.java_labor_beadando.modelclasses.Meccsek;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dataRepository extends CrudRepository<Meccsek, Integer> {

}

