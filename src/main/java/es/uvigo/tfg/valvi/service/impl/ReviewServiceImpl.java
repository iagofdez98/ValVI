package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.ReviewDto;
import es.uvigo.tfg.valvi.entity.Review;
import es.uvigo.tfg.valvi.mapper.ReviewMapper;
import es.uvigo.tfg.valvi.repository.ReviewRepository;
import es.uvigo.tfg.valvi.service.ReviewService;
import javax.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Review service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

  @NonNull
  private ReviewRepository reviewRepository;

  @NonNull
  private ReviewMapper reviewMapper;
  
  @Override
  public List<ReviewDto> findReviewsByVideogame(Integer videogameId) {
    List<Review> reviews = this.reviewRepository.findByVideogameId(videogameId);
    return this.reviewMapper.toReviewDtoList(reviews);
  }

  @Override
  public List<ReviewDto> findReviewsByUser(String username) {
    List<Review> reviews = this.reviewRepository.findByUsername(username);
    return this.reviewMapper.toReviewDtoList(reviews);
  }

  @Override
  public ReviewDto upsertReview(ReviewDto reviewDto) {
    Review review = this.reviewRepository.save(this.reviewMapper.toReview(reviewDto));
    return this.reviewMapper.toReviewDto(review);
  }

  @Override
  public Integer deleteReview(Integer id) {
    this.reviewRepository.deleteById(id);;
    return id;
  }
}
