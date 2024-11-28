package com.example.testspringboot.mappers;
import com.example.testspringboot.entities.Film;
import com.example.testspringboot.dtos.FilmDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FilmMapperImpl {
    @Mapping(target = "acteurs", source = "acteurs")
    FilmDTO filmToFilmDTO(Film film);

    @Mapping(target = "acteurs", source = "acteurs")
    Film filmDTOToFilm(FilmDTO filmDTO);
}
