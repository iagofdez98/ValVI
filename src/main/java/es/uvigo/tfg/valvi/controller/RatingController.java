package es.uvigo.tfg.valvi.controller;

import es.uvigo.tfg.valvi.dto.ReducedRatingDto;
import es.uvigo.tfg.valvi.service.RatingService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Rating controller.
 */
@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/ratings")
public class RatingController {
  
  @Autowired
  private RatingService ratingService;

  /**
   * Get average rating by videogame long.
   *
   * @param id the id
   * @return the long
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Long getAverageRatingByVideogame(@NonNull Integer id){
    return this.ratingService.getAverageRatingByVideogame(id);
  }

  /**
   * Get rating by user rating dto.
   *
   * @param username the username
   * @return the rating dto
   */
  @GetMapping("/{username}")
  @ResponseStatus(HttpStatus.OK)
  public List<ReducedRatingDto> getRatingByUser(@NonNull @PathVariable String username){
    return this.ratingService.getRatingByUser(username);
  }

  /**
   * Upsert rating rating dto.
   *
   * @param ratingDto the rating dto
   * @return the rating dto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ReducedRatingDto upsertRating(@RequestBody ReducedRatingDto ratingDto){
    return this.ratingService.upsertRating(ratingDto);
  }

  /**
   * Delete rating integer.
   *
   * @param id the id
   * @return the integer
   */
  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public Integer deleteRating(Integer id) {
    return this.ratingService.deleteRating(id);
  }
  
  @GetMapping("/{videogameId}/{username}")
  @ResponseStatus(HttpStatus.OK)
  public ReducedRatingDto getRatingVideogameByIdAndUsername(@NonNull @PathVariable Integer videogameId, @NonNull @PathVariable String username) {
    return this.ratingService.getRatingVideogameByIdAndUsername(videogameId, username);
  }
}
