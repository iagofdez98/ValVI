package es.uvigo.tfg.valvi.service;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GenreDto;

/**
 * The interface Genre service.
 */
public interface GenreService {

  /**
   * Create genre genre dto.
   *
   * @param genreDto the genre dto
   * @return the genre dto
   */
  GenreDto createGenre(GenreDto genreDto);

  /**
   * Gets genres.
   *
   * @return the genres
   */
  List<GenreDto> getGenres();
}
