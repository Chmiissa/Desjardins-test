package com.example.testspringboot.service;
import com.example.testspringboot.exceptions.FilmNotFoundException;
import com.example.testspringboot.dtos.FilmDTO;


public interface FilmService {
    FilmDTO createFilm(FilmDTO filmDTO);
    FilmDTO getFilmById(Long id) throws FilmNotFoundException;

}
