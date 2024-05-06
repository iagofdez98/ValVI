package es.uvigo.tfg.valvi.mapper;
import java.util.List;

import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.entity.Videogame;
import org.mapstruct.Mapper;

/**
 * The interface Videogame mapper.
 */
@Mapper(componentModel = "spring")
public interface VideogameMapper {

    /**
     * To videogame dto videogame dto.
     *
     * @param videogame the videogame
     * @return the videogame dto
     */
    VideogameDto toVideogameDto(Videogame videogame);

    /**
     * To videogame videogame.
     *
     * @param dto the dto
     * @return the videogame
     */
    Videogame toVideogame(VideogameDto dto);
    
    List<VideogameDto> toVideogameDtoList(List<Videogame> videogames);
    
    Videogame toVideogameFromString(String videogame);
    

}
