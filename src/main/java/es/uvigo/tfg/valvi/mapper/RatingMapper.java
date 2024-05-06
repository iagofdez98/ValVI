package es.uvigo.tfg.valvi.mapper;

import es.uvigo.tfg.valvi.dto.RatingDto;
import es.uvigo.tfg.valvi.dto.ReducedRatingDto;
import es.uvigo.tfg.valvi.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * The interface Rating mapper.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, VideogameMapper.class})
public interface RatingMapper {

    /**
     * To rating dto rating dto.
     *
     * @param rating the rating
     * @return the rating dto
     */
    RatingDto toRatingDto(Rating rating);

    /**
     * To rating rating.
     *
     * @param dto the dto
     * @return the rating
     */
    Rating toRating(RatingDto dto);
    
    /**
     * To reduced rating dto reduced rating dto.
     *
     * @param rating the rating
     * @return the reduced rating dto
     */
    @Mapping(source = "username.username", target = "username")
    ReducedRatingDto toReducedRatingDto(Rating rating);
    
    /**
     * To reduced rating dto list list.
     *
     * @param ratings the ratings
     * @return the list
     */
    List<ReducedRatingDto> toReducedRatingDtoList(List<Rating> ratings);
}
