package es.uvigo.tfg.valvi.repository;

import es.uvigo.tfg.valvi.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Videogame repository.
 */
@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Integer > { }
