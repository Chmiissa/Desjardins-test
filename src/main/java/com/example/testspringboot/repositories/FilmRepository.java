package com.example.testspringboot.repositories;

import com.example.testspringboot.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    boolean existsByTitre(String titre);
}
