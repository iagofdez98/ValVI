package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.RatingDto;
import es.uvigo.tfg.valvi.entity.Rating;
import es.uvigo.tfg.valvi.entity.Videogame;
import es.uvigo.tfg.valvi.mapper.RatingMapper;
import es.uvigo.tfg.valvi.repository.RatingRepository;
import es.uvigo.tfg.valvi.repository.VideogameRepository;
import es.uvigo.tfg.valvi.service.RatingService;
import javax.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Rating service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class RatingServiceImpl implements RatingService {

  @NonNull
  private RatingRepository ratingRepository;
  
  @NonNull
  private VideogameRepository videogameRepository;

  @NonNull
  private RatingMapper ratingMapper;
  
  @Override
  public Long getAverageRatingByVideogame(Integer id) {
    Videogame videogame = this.videogameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    List<Rating> ratings = this.ratingRepository.findRatingsByVideogame(videogame);
    return this.calculateAverageRating(ratings);
  }

  @Override
  public RatingDto getRatingByUser(String username) {
    Rating rating = this.ratingRepository.findByUsername(username);
    return this.ratingMapper.toRatingDto(rating); 
  }

  @Override
  public RatingDto upsertRating(RatingDto ratingDto){
    Rating rating = this.ratingRepository.save(this.ratingMapper.toRating(ratingDto));
    return this.ratingMapper.toRatingDto(rating);
  }

  @Override
  public Integer deleteRating(Integer id) {
    this.ratingRepository.deleteById(id);
    return id;
  }

  private Long calculateAverageRating(List<Rating> ratingList){
    Integer total = null;
    
    for (Rating r: ratingList) {
      if(r.getQualification() != null){
        total += r.getQualification();
      }
    }

    if(total != null){
      return (long) (total / ratingList.size());
    }
    return null;
  }
}
