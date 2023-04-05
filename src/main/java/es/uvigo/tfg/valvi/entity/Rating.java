package es.uvigo.tfg.valvi.entity;

import es.uvigo.tfg.valvi.enumerate.VideogameStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * The type Rating.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RATING")
public class Rating {
    
    @Id
    private UUID id;
    
    private Integer qualification;
    
    private VideogameStateEnum state;
    
    @OneToOne
    @JoinColumn(name = "videogame_id", referencedColumnName = "id")
    private Videogame videogame;
    
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
}
