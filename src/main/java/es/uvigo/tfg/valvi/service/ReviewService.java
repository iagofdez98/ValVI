package es.uvigo.tfg.valvi.service;

import java.util.List;

import es.uvigo.tfg.valvi.dto.ReviewDto;

/**
 * The interface Review service.
 */
public interface ReviewService {

  /**
   * Find reviews by videogame list.
   *
   * @param videogameId the videogame id
   * @return the list
   */
  List<ReviewDto> findReviewsByVideogame(Integer videogameId);

  /**
   * Find reviews by user list.
   *
   * @param username the username
   * @return the list
   */
  List<ReviewDto> findReviewsByUser(String username);

  /**
   * Upsert review review dto.
   *
   * @param reviewDto the review dto
   * @return the review dto
   */
  ReviewDto upsertReview(ReviewDto reviewDto);

  /**
   * Delete review integer.
   *
   * @param id the id
   * @return the integer
   */
  Integer deleteReview(Integer id);
}
