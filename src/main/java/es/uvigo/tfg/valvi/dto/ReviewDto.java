package es.uvigo.tfg.valvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The type Review dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ReviewDto {

    private Integer id;

    private String title;

    private String description;

    private VideogameDto videogame;

    private UserDto username;

    private LocalDate date;
}
