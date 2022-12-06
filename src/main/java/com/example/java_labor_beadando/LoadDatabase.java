package com.example.java_labor_beadando;

import com.example.java_labor_beadando.modelclasses.Meccsek;
import com.example.java_labor_beadando.repositories.dataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log= LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(dataRepository dataRepository) {
        return args -> {
            if(false){
                dataRepository.save(new Meccsek(21, "2019.03.27", "15:00:00", "bajnoki",500 ));
            }
        };
    }
}
