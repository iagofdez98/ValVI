package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.RatingDto;
import es.uvigo.tfg.valvi.dto.ReducedRatingDto;
import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.entity.Rating;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.entity.Videogame;
import es.uvigo.tfg.valvi.enumerate.VideogameStateEnum;
import es.uvigo.tfg.valvi.mapper.RatingMapper;
import es.uvigo.tfg.valvi.mapper.UserMapper;
import es.uvigo.tfg.valvi.mapper.VideogameMapper;
import es.uvigo.tfg.valvi.repository.RatingRepository;
import es.uvigo.tfg.valvi.repository.VideogameRepository;
import es.uvigo.tfg.valvi.service.RatingService;
import javax.persistence.EntityNotFoundException;

import es.uvigo.tfg.valvi.service.UserService;
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
  private UserService userService;
  
  @NonNull
  private UserMapper userMapper;
  
  @NonNull
  private RatingMapper ratingMapper;
  
  @NonNull
  private VideogameMapper videogameMapper;
  
  @Override
  public ReducedRatingDto getRatingVideogameByIdAndUsername(Integer videogameId, String username) {
    Videogame videogame = this.videogameRepository.findById(videogameId).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    User user = this.userMapper.toUser(this.userService.findUser(username));
    Rating rating = this.ratingRepository.findByUsernameAndVideogame(user, videogame);
    return this.ratingMapper.toReducedRatingDto(rating);
  }
  
  @Override
  public Long getAverageRatingByVideogame(Integer id) {
    Videogame videogame = this.videogameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    List<Rating> ratings = this.ratingRepository.findRatingsByVideogame(videogame);
    return this.calculateAverageRating(ratings);
  }

  @Override
  public List<ReducedRatingDto> getRatingByUser(String username) {
    User user = this.userMapper.toUser(this.userService.findUser(username));
    List<Rating> ratingList = this.ratingRepository.findByUsername(user);
    return this.ratingMapper.toReducedRatingDtoList(ratingList); 
  }

  @Override
  public ReducedRatingDto upsertRating(ReducedRatingDto ratingDto){
    Rating existingRate = this.ratingRepository.findByUsernameAndVideogame(this.userMapper.toUser(this.userService.findUser(ratingDto.getUsername())),
            this.videogameMapper.toVideogame(ratingDto.getVideogame()));
    
    UserDto user = this.userService.findUser(ratingDto.getUsername());
    RatingDto savedRating = RatingDto.builder()
            .qualification(ratingDto.getQualification())
            .state(VideogameStateEnum.valueOf(ratingDto.getState() != null ? ratingDto.getState() : "NONE"))
            .username(user)
            .videogame(ratingDto.getVideogame())
            .build();
    
    if(existingRate != null){
      savedRating.setId(existingRate.getId());
      savedRating.setState(ratingDto.getState() == null ? existingRate.getState() : VideogameStateEnum.valueOf(ratingDto.getState()));
    }
    
    Rating rating = this.ratingRepository.save(this.ratingMapper.toRating(savedRating));
    return this.ratingMapper.toReducedRatingDto(rating);
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
