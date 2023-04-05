package es.uvigo.tfg.valvi.dto;

import es.uvigo.tfg.valvi.enumerate.VideogameStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * The type Rating dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RatingDto {

    private UUID id;

    private Integer qualification;

    private VideogameStateEnum state;

    private VideogameDto videogame;

    private UserDto username;
}
