package com.example.springapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.saveAll(List.of(
                            new Stundent("James", "james@mail.com", LocalDate.of(2006, Month.MAY, 3)),
                            new Stundent("Mina", "mina@mail.com", LocalDate.of(2015, Month.AUGUST, 28))
                    )
            );
        };
    }
}
