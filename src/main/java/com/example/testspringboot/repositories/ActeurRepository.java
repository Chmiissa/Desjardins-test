package com.example.testspringboot.repositories;

import com.example.testspringboot.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {
}
