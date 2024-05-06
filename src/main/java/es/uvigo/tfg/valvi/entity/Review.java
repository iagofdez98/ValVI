package es.uvigo.tfg.valvi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Review.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
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
