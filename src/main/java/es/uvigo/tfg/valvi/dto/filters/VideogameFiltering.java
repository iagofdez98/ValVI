package es.uvigo.tfg.valvi.dto.filters;

import java.time.LocalDate;
import java.util.List;

import es.uvigo.tfg.valvi.dto.DeveloperDto;
import es.uvigo.tfg.valvi.dto.GenreDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Videogame filtering.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class VideogameFiltering {
  
  private Integer requiredAge;

  private String name;
  
  private String storeName;

  private LocalDate releaseDate;

  private Long averageRating;
  
  private List<GenreDto> genres;

  private List<DeveloperDto> developer;
}
