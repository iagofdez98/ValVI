package es.uvigo.tfg.valvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * The type Videogame dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class VideogameDto {

    private UUID id;

    private Integer requiredAge;

    private String name;

    private String image;
    
    private String description;

    private Integer storeId;

    private String storeName;

    private LocalDate releaseDate;

    private Long averageRating;
    
    private List<GenreDto> genres;

    private List<DeveloperDto> developer;
}
