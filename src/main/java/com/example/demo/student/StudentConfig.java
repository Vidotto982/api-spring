package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
        @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
            return args -> {
            Student mariam= new Student(
                        "Mariam",
                            "marian@gmail.com",
                        LocalDate.of(1998, JUNE, 7)
                );
                Student leandro= new Student(
                        "Leandro",
                        "leandro@gmail.com",
                        LocalDate.of(1997, JULY, 22)
                );
                repository.saveAll(
                        List.of(mariam, leandro)
                );
            };
        }

}
