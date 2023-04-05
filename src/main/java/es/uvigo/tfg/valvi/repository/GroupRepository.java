package es.uvigo.tfg.valvi.repository;

import java.util.List;

import es.uvigo.tfg.valvi.entity.Group;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Group repository.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

  /**
   * Find groups by username and videogames containing list.
   *
   * @param username  the username
   * @param videogame the videogame
   * @return the list
   */
  List<Group> findGroupsByUsernameAndVideogamesContaining(String username, Videogame videogame);
}
