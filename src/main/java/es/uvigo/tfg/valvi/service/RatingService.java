package es.uvigo.tfg.valvi.service;

import es.uvigo.tfg.valvi.dto.ReducedRatingDto;

import java.util.List;

/**
 * The interface Rating service.
 */
public interface RatingService {

  /**
   * Gets rating videogame by id and username.
   *
   * @param videogameId the videogame id
   * @param username    the username
   * @return the rating videogame by id and username
   */
  ReducedRatingDto getRatingVideogameByIdAndUsername(Integer videogameId, String username);

  /**
   * Gets average rating by videogame.
   *
   * @param id the id
   * @return the average rating by videogame
   */
  Long getAverageRatingByVideogame(Integer id);

  /**
   * Gets rating by user.
   *
   * @param username the username
   * @return the rating by user
   */
  List<ReducedRatingDto> getRatingByUser(String username);

  /**
   * Upsert rating rating dto.
   *
   * @param ratingDto the rating dto
   * @return the rating dto
   */
  ReducedRatingDto upsertRating(ReducedRatingDto ratingDto);

  /**
   * Delete rating integer.
   *
   * @param id the id
   * @return the integer
   */
  Integer deleteRating(Integer id);
}
