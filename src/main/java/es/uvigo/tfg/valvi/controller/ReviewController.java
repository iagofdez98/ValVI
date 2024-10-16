package es.uvigo.tfg.valvi.controller;

import java.util.List;

import es.uvigo.tfg.valvi.dto.ReviewDto;
import es.uvigo.tfg.valvi.service.ReviewService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Review controller.
 */
@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/reviews")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  /**
   * Find reviews by videogame list.
   *
   * @param id the id
   * @return the list
   */
  @GetMapping("/game/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<ReviewDto> findReviewsByVideogame(@NonNull @PathVariable Integer id){
    return this.reviewService.findReviewsByVideogame(id);
  }

  /**
   * Find reviews by user list.
   *
   * @param username the username
   * @return the list
   */
  @GetMapping("/{username}")
  @ResponseStatus(HttpStatus.OK)
  public List<ReviewDto> findReviewsByUser(@NonNull @PathVariable String username){
    return this.reviewService.findReviewsByUser(username);
  }

  /**
   * Find last reviews list.
   *
   * @param integer the integer
   * @return the list
   */
  @GetMapping("/lastReviews/{integer}")
  @ResponseStatus(HttpStatus.OK)
  public List<ReviewDto> findLastReviews(@NonNull @PathVariable Integer integer){
    return this.reviewService.findLastReviews(integer);
  }

  /**
   * Upsert review review dto.
   *
   * @param reviewDto the review dto
   * @return the review dto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ReviewDto upsertReview(@RequestBody ReviewDto reviewDto){
    return this.reviewService.upsertReview(reviewDto);
  }

  /**
   * Delete review integer.
   *
   * @param id the id
   * @return the integer
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Integer deleteReview(@NonNull @PathVariable Integer id){
    return this.reviewService.deleteReview(id);
  }
}
