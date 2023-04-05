package es.uvigo.tfg.valvi.mapper;
import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.entity.Videogame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    @Mapping(source = "id", target = "id", defaultExpression = "java( java.util.UUID.randomUUID() )")
    Videogame toVideogame(VideogameDto dto);
}
