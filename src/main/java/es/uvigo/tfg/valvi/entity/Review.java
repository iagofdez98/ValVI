package es.uvigo.tfg.valvi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * The type Review.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEW")
public class Review {
    
    @Id
    private UUID id;
    
    private String title;
    
    private String description;

    @OneToOne
    @JoinColumn(name = "videogame_id", referencedColumnName = "id")
    private Videogame videogameId;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
    
    private LocalDate date;
}
