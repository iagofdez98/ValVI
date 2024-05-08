package es.uvigo.tfg.valvi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Videogame.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VIDEOGAMES")
public class Videogame {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "REQUIRED_AGE")
    private Integer requiredAge;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "IMAGE")
    private String image;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;
    
    @Column(name = "AVG_RATING")
    private Long averageRating;
    
    @Column(name = "DEVELOPER")
    private String developer;

    @ManyToMany
    @JoinTable(
        name = "genres_videogames",
        joinColumns = @JoinColumn(name = "id_videogame"),
        inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
        name = "lists_videogames",
        joinColumns = @JoinColumn(name = "id_videogame"),
        inverseJoinColumns = @JoinColumn(name = "id_list")
    )
    private List<Group> groups;
}
