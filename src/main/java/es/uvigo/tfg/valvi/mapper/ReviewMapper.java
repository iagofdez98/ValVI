package es.uvigo.tfg.valvi.mapper;

import java.util.List;

import es.uvigo.tfg.valvi.dto.ReviewDto;
import es.uvigo.tfg.valvi.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Review mapper.
 */
@Mapper(componentModel = "spring")
public interface ReviewMapper {

    /**
     * To review dto review dto.
     *
     * @param review the review
     * @return the review dto
     */
    ReviewDto toReviewDto(Review review);

    /**
     * To review review.
     *
     * @param dto the dto
     * @return the review
     */
    @Mapping(source = "id", target = "id", defaultExpression = "java( java.util.UUID.randomUUID() )")
    Review toReview(ReviewDto dto);

    /**
     * To review list list.
     *
     * @param dtos the dtos
     * @return the list
     */
    List<Review> toReviewList(List<ReviewDto> dtos);

    /**
     * To review dto list list.
     *
     * @param dtos the dtos
     * @return the list
     */
    List<ReviewDto> toReviewDtoList(List<Review> dtos);
}
