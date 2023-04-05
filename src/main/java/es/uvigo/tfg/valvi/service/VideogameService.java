package es.uvigo.tfg.valvi.service;

import java.util.List;

import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.dto.filters.VideogameFiltering;

/**
 * The interface Videogame service.
 */
public interface VideogameService {

  /**
   * Find videogames list.
   *
   * @param videogameFiltering the videogame filtering
   * @return the list
   */
  List<VideogameDto> findVideogames(VideogameFiltering videogameFiltering);

  /**
   * Upsert videogame videogame dto.
   *
   * @param videogameDto the videogame dto
   * @return the videogame dto
   */
  VideogameDto upsertVideogame(VideogameDto videogameDto);

  /**
   * Delete videogame integer.
   *
   * @param id the id
   * @return the integer
   */
  Integer deleteVideogame(Integer id);
  
}
