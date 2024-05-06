package es.uvigo.tfg.valvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Videogame dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class VideogameDto {

    private Integer id;

    private Integer requiredAge;

    private String name;

    private String image;
    
    private String description;
    
    private LocalDate releaseDate;

    private Long averageRating;
    
    private List<GenreDto> genres;

    private String developer;
}
