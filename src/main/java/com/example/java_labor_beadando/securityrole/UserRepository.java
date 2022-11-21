package com.example.java_labor_beadando.securityrole;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User>findByEmail(String email);
}
