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
 * The type Group.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LIST")
public class Group {
    
    @Id
    private UUID id;
    
    private String name;
    
    private String description;
    
    private LocalDate date;
    
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
    
    @OneToMany
    private List<Videogame> videogames;
}
