package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GenreDto;
import es.uvigo.tfg.valvi.entity.Genre;
import es.uvigo.tfg.valvi.mapper.GenreMapper;
import es.uvigo.tfg.valvi.repository.GenreRepository;
import es.uvigo.tfg.valvi.service.GenreService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Genre service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService {

  @NonNull
  private GenreRepository genreRepository;

  @NonNull
  private GenreMapper genreMapper;
  
  
  @Override
  public GenreDto createGenre(GenreDto genreDto) {
    Genre genre = this.genreRepository.save(this.genreMapper.toGenre(genreDto));
    return this.genreMapper.toGenreDto(genre);
  }

  @Override
  public List<GenreDto> getGenres() {
    return this.genreMapper.toGenreDtoList(this.genreRepository.findAll());
  }
}
