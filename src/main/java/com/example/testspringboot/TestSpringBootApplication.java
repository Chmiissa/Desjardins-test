package com.example.testspringboot;

import com.example.testspringboot.entities.Acteur;
import com.example.testspringboot.entities.Film;
import com.example.testspringboot.repositories.ActeurRepository;
import com.example.testspringboot.repositories.FilmRepository;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class TestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner start(FilmRepository filmRepository, ActeurRepository acteurRepository) {
        return args -> Stream.of("Star Wars: The Empire Strikes Back", "Movie2", "Movie3").forEach(titre -> {
            Film film = new Film();
            film.setTitre(titre);
            film.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");


            Set<Acteur> acteurs = getActeurs();

            film.setActeurs(acteurs);

            filmRepository.save(film);
        });
    }

    private static Set<Acteur> getActeurs() {
        Set<Acteur> acteurs = new HashSet<>();

        Acteur acteur = new Acteur();
        acteur.setNom("Ford");
        acteur.setPrenom("Harrison");

        acteurs.add(acteur); // Ajoute acteur au Set d'acteurs de film

        Acteur acteur1 = new Acteur();
        acteur1.setNom("Hamill");
        acteur1.setPrenom("Mark");

        acteurs.add(acteur1); // Ajoute acteur au Set d'acteurs de film
        return acteurs;
    }

}
