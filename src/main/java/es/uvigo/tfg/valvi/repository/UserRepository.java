package es.uvigo.tfg.valvi.repository;

import es.uvigo.tfg.valvi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String > {
  
  User findByUsername(String username);
}
