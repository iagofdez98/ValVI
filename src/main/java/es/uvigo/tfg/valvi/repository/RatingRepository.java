package es.uvigo.tfg.valvi.repository;

import java.util.List;

import es.uvigo.tfg.valvi.entity.Rating;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Rating repository.
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

  /**
   * Find ratings by videogame list.
   *
   * @param videogame the videogame
   * @return the list
   */
  List<Rating> findRatingsByVideogame(Videogame videogame);

  /**
   * Find by username rating.
   *
   * @param username the username
   * @return the rating
   */
  List<Rating> findByUsername(User username);

  Rating findByUsernameAndVideogame(User username, Videogame videogame);
}
