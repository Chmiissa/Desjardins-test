package com.example.testspringboot.mappers;

import com.example.testspringboot.dtos.ActeurDTO;
import com.example.testspringboot.entities.Acteur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActeurMapperImpl {

    Acteur dtoToActeur(ActeurDTO acteurDTO);
    ActeurDTO acteurToDto(Acteur acteur);

}

