package com.example.testspringboot.mappers;

import com.example.testspringboot.dtos.ActeurDTO;
import com.example.testspringboot.dtos.FilmDTO;
import com.example.testspringboot.entities.Acteur;
import com.example.testspringboot.entities.Film;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T12:29:35-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class FilmMapperImplImpl implements FilmMapperImpl {

    @Override
    public FilmDTO filmToFilmDTO(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDTO filmDTO = new FilmDTO();

        filmDTO.setActeurs( acteurSetToActeurDTOSet( film.getActeurs() ) );
        filmDTO.setId( film.getId() );
        filmDTO.setTitre( film.getTitre() );
        filmDTO.setDescription( film.getDescription() );

        return filmDTO;
    }

    @Override
    public Film filmDTOToFilm(FilmDTO filmDTO) {
        if ( filmDTO == null ) {
            return null;
        }

        Film film = new Film();

        film.setActeurs( acteurDTOSetToActeurSet( filmDTO.getActeurs() ) );
        film.setId( filmDTO.getId() );
        film.setTitre( filmDTO.getTitre() );
        film.setDescription( filmDTO.getDescription() );

        return film;
    }

    protected ActeurDTO acteurToActeurDTO(Acteur acteur) {
        if ( acteur == null ) {
            return null;
        }

        ActeurDTO acteurDTO = new ActeurDTO();

        acteurDTO.setId( acteur.getId() );
        acteurDTO.setNom( acteur.getNom() );
        acteurDTO.setPrenom( acteur.getPrenom() );

        return acteurDTO;
    }

    protected Set<ActeurDTO> acteurSetToActeurDTOSet(Set<Acteur> set) {
        if ( set == null ) {
            return null;
        }

        Set<ActeurDTO> set1 = new LinkedHashSet<ActeurDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Acteur acteur : set ) {
            set1.add( acteurToActeurDTO( acteur ) );
        }

        return set1;
    }

    protected Acteur acteurDTOToActeur(ActeurDTO acteurDTO) {
        if ( acteurDTO == null ) {
            return null;
        }

        Acteur acteur = new Acteur();

        acteur.setId( acteurDTO.getId() );
        acteur.setNom( acteurDTO.getNom() );
        acteur.setPrenom( acteurDTO.getPrenom() );

        return acteur;
    }

    protected Set<Acteur> acteurDTOSetToActeurSet(Set<ActeurDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Acteur> set1 = new LinkedHashSet<Acteur>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ActeurDTO acteurDTO : set ) {
            set1.add( acteurDTOToActeur( acteurDTO ) );
        }

        return set1;
    }
}
