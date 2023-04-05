package es.uvigo.tfg.valvi.repository;

import java.util.List;

import es.uvigo.tfg.valvi.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Review repository.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer > {

  /**
   * Find by username list.
   *
   * @param username the username
   * @return the list
   */
  List<Review> findByUsername(String username);

  /**
   * Find by videogame id list.
   *
   * @param id the id
   * @return the list
   */
  List<Review> findByVideogameId(Integer id);
}
