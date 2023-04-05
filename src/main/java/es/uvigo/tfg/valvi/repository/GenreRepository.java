package es.uvigo.tfg.valvi.repository;

import es.uvigo.tfg.valvi.entity.Genre;
import es.uvigo.tfg.valvi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Genre repository.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
