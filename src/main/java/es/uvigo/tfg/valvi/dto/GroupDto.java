package es.uvigo.tfg.valvi.dto;

import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.entity.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * The type Group dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GroupDto {

    private UUID id;

    private String name;

    private String description;

    private LocalDate date;

    private UserDto username;

    private List<VideogameDto> videogames;
}
