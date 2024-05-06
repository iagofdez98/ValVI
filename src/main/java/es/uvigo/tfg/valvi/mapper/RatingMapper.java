package es.uvigo.tfg.valvi.mapper;

import es.uvigo.tfg.valvi.dto.RatingDto;
import es.uvigo.tfg.valvi.entity.Rating;
import org.mapstruct.Mapper;

/**
 * The interface Rating mapper.
 */
@Mapper(componentModel = "spring")
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
}
