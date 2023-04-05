package es.uvigo.tfg.valvi.repository;

import es.uvigo.tfg.valvi.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Developer repository.
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}
