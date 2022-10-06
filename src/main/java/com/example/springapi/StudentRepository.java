package com.example.springapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Stundent, Long> {

    Optional<Stundent> findByEmail(String email);

}
