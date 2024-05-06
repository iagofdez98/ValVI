package es.uvigo.tfg.valvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ReducedRatingDto {

    private Integer id;

    private Integer qualification;

    private String state;

    private VideogameDto videogame;

    private String username;
}

