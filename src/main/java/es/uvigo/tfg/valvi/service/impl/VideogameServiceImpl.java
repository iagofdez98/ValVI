package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.dto.filters.VideogameFiltering;
import es.uvigo.tfg.valvi.mapper.VideogameMapper;
import es.uvigo.tfg.valvi.repository.VideogameRepository;
import es.uvigo.tfg.valvi.service.VideogameService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Videogame service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class VideogameServiceImpl implements VideogameService {
  
  @NonNull
  private VideogameRepository videogameRepository;
  @NonNull
  private VideogameMapper videogameMapper;
  
  @Override
  public List<VideogameDto> findVideogames(VideogameFiltering videogameFiltering){
    return this.videogameMapper.toVideogameDtoList(this.videogameRepository.findAll());
  }

  @Override
  public VideogameDto upsertVideogame(VideogameDto videogameDto){
    this.videogameRepository.save(this.videogameMapper.toVideogame(videogameDto));
    return videogameDto;
  }
  
  @Override
  public VideogameDto getVideogameById(Integer id){
      return this.videogameMapper.toVideogameDto(this.videogameRepository.findById(id).orElse(null));
  }
  
  @Override
  public Integer deleteVideogame(Integer id){
    this.videogameRepository.deleteById(id);
    return id;
  }
  
}
