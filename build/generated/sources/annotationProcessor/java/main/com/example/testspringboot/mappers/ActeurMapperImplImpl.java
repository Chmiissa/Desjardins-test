package com.example.testspringboot.mappers;

import com.example.testspringboot.dtos.ActeurDTO;
import com.example.testspringboot.entities.Acteur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T12:29:35-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ActeurMapperImplImpl implements ActeurMapperImpl {

    @Override
    public Acteur dtoToActeur(ActeurDTO acteurDTO) {
        if ( acteurDTO == null ) {
            return null;
        }

        Acteur acteur = new Acteur();

        acteur.setId( acteurDTO.getId() );
        acteur.setNom( acteurDTO.getNom() );
        acteur.setPrenom( acteurDTO.getPrenom() );

        return acteur;
    }

    @Override
    public ActeurDTO acteurToDto(Acteur acteur) {
        if ( acteur == null ) {
            return null;
        }

        ActeurDTO acteurDTO = new ActeurDTO();

        acteurDTO.setId( acteur.getId() );
        acteurDTO.setNom( acteur.getNom() );
        acteurDTO.setPrenom( acteur.getPrenom() );

        return acteurDTO;
    }
}
