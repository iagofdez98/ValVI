package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.dto.filters.VideogameFiltering;
import es.uvigo.tfg.valvi.entity.Videogame;
import es.uvigo.tfg.valvi.mapper.VideogameMapper;
import es.uvigo.tfg.valvi.repository.VideogameRepository;
import es.uvigo.tfg.valvi.service.VideogameService;
import javax.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
    return null;
  }

  @Override
  public VideogameDto upsertVideogame(VideogameDto videogameDto){
    Videogame videogame = this.videogameRepository.save(this.videogameMapper.toVideogame(videogameDto));
    return this.videogameMapper.toVideogameDto(videogame);
  }
  
  @Override
  public Integer deleteVideogame(Integer id){
    this.videogameRepository.deleteById(id);
    return id;
  }
  
}
