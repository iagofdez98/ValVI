package es.uvigo.tfg.valvi.service;

import es.uvigo.tfg.valvi.dto.RatingDto;

/**
 * The interface Rating service.
 */
public interface RatingService {

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
  RatingDto getRatingByUser(String username);

  /**
   * Upsert rating rating dto.
   *
   * @param ratingDto the rating dto
   * @return the rating dto
   */
  RatingDto upsertRating(RatingDto ratingDto);

  /**
   * Delete rating integer.
   *
   * @param id the id
   * @return the integer
   */
  Integer deleteRating(Integer id);
}
