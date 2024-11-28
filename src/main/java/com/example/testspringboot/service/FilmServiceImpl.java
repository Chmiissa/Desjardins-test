package com.example.testspringboot.service;

import com.example.testspringboot.entities.Acteur;
import com.example.testspringboot.entities.Film;
import com.example.testspringboot.exceptions.FilmNotFoundException;
import com.example.testspringboot.exceptions.InvalidDataException;
import com.example.testspringboot.exceptions.ResourceAlreadyExistsException;
import com.example.testspringboot.mappers.FilmMapperImpl;
import com.example.testspringboot.repositories.FilmRepository;
import com.example.testspringboot.dtos.FilmDTO;
import com.example.testspringboot.mappers.ActeurMapperImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor // MapStruct ne sont pas détectées par @AllArgsConstructor
@Transactional
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapperImpl filmMapperImpl;
    private final ActeurMapperImpl acteurMapperImpl;

    @Override
    public FilmDTO createFilm(FilmDTO filmDTO) {
        if(filmDTO.getTitre() == null || filmDTO.getTitre().isEmpty()) {
            throw new InvalidDataException("Le titre du film ne peut être vide.");
        }

        boolean exists = filmRepository.existsByTitre(filmDTO.getTitre());
        if(exists) {
            throw new ResourceAlreadyExistsException("Le film avec le titre " + filmDTO.getTitre() + " existe déjà.");
        }
        Film film = filmMapperImpl.filmDTOToFilm(filmDTO);

        if (filmDTO.getActeurs() != null) {
            Set<Acteur> acteurs = filmDTO.getActeurs().stream()
                    .map(acteurMapperImpl::dtoToActeur)
                    .collect(Collectors.toSet());
            film.setActeurs(acteurs);
        }
        Film savedFilm = filmRepository.save(film);
        return filmMapperImpl.filmToFilmDTO(savedFilm);
    }

    @Override
    public FilmDTO getFilmById(Long id) throws FilmNotFoundException {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException("Film non trouvé avec l'id: " + id));
        return filmMapperImpl.filmToFilmDTO(film);
    }
}
