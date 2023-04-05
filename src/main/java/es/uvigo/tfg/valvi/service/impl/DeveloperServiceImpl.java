package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.DeveloperDto;
import es.uvigo.tfg.valvi.entity.Developer;
import es.uvigo.tfg.valvi.mapper.DeveloperMapper;
import es.uvigo.tfg.valvi.repository.DeveloperRepository;
import es.uvigo.tfg.valvi.service.DeveloperService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Developer service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class DeveloperServiceImpl implements DeveloperService {
  
  @NonNull
  private DeveloperRepository developerRepository;
  
  @NonNull
  private DeveloperMapper developerMapper;

  @Override
  public DeveloperDto createDeveloper(DeveloperDto developerDto) {
    Developer developer = this.developerRepository.save(this.developerMapper.toDeveloper(developerDto));
    return this.developerMapper.toDeveloperDto(developer);
  }

  @Override
  public List<DeveloperDto> findDevelopers() {
    return this.developerMapper.toDeveloperDtoList(this.developerRepository.findAll());
  }
}
