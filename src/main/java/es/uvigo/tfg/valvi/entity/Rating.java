package es.uvigo.tfg.valvi.entity;

import es.uvigo.tfg.valvi.enumerate.VideogameStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Rating.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS_VIDEOGAMES")
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "rating")
    private Integer qualification;
    
    @Column(name = "state")
    private VideogameStateEnum state;
    
    @OneToOne
    @JoinColumn(name = "id_videogame", referencedColumnName = "id")
    private Videogame videogame;
    
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
}
