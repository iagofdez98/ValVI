package es.uvigo.tfg.valvi.service.impl;

import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.mapper.UserMapper;
import es.uvigo.tfg.valvi.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import es.uvigo.tfg.valvi.dto.ReviewDto;
import es.uvigo.tfg.valvi.entity.Review;
import es.uvigo.tfg.valvi.mapper.ReviewMapper;
import es.uvigo.tfg.valvi.repository.ReviewRepository;
import es.uvigo.tfg.valvi.service.ReviewService;
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
  
  @NonNull
  private UserService userService;
  
  @NonNull
  private UserMapper userMapper;
  
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
    UserDto user = this.userService.findUser(reviewDto.getUsername());
    reviewDto.setUsername(null);
    Review review = this.reviewMapper.toReview(reviewDto);
    review.setUsername(this.userMapper.toUser(user));
    review.setDate(LocalDate.now());
    this.reviewRepository.save(review);
    return this.reviewMapper.toReviewDto(review);
  }

  @Override
  public Integer deleteReview(Integer id) {
    this.reviewRepository.deleteById(id);;
    return id;
  }

  @Override
  public List<ReviewDto> findLastReviews(Integer integer) {
    Pageable pageable = PageRequest.of(0, integer);
    return this.reviewMapper.toReviewDtoList(this.reviewRepository.findByOrderByDateDesc(pageable));
  }
}
