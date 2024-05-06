package es.uvigo.tfg.valvi.mapper;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GenreDto;
import es.uvigo.tfg.valvi.entity.Genre;
import org.mapstruct.Mapper;

/**
 * The interface Genre mapper.
 */
@Mapper(componentModel = "spring")
public interface GenreMapper {

    /**
     * To genre dto genre dto.
     *
     * @param genre the genre
     * @return the genre dto
     */
    GenreDto toGenreDto(Genre genre);

    /**
     * To genre genre.
     *
     * @param dto the dto
     * @return the genre
     */
    Genre toGenre(GenreDto dto);

    /**
     * To genre dto list list.
     *
     * @param genres the genres
     * @return the list
     */
    List<GenreDto> toGenreDtoList(List<Genre> genres);
}
