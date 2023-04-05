package es.uvigo.tfg.valvi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * The type Videogame.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VIDEOGAME")
public class Videogame {
    
    @Id
    private UUID id;
    
    private Integer requiredAge;
    
    private String name;
    
    private String image;
    
    private Integer storeId;
    
    private String storeName;
    
    private LocalDate releaseDate;
    
    private Long averageRating;
    
    @OneToMany
    private List<Genre> genres;
    
    @OneToMany
    private List<Developer> developers;
}
