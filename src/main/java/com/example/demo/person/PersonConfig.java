package com.example.demo.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            Person marian = new Person(
                    "Marian",
                    "De Leon",
                    "Argentina"
            );
            Person leandro= new Person(
                    "Leandro",
                    "Vicari",
                    "Chile"
            );
            repository.saveAll(
                    List.of(marian, leandro)
            );
        };
    }


}
