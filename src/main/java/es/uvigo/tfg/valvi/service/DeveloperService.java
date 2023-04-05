package es.uvigo.tfg.valvi.service;

import java.util.List;

import es.uvigo.tfg.valvi.dto.DeveloperDto;

/**
 * The interface Developer service.
 */
public interface DeveloperService {

  /**
   * Create developer developer dto.
   *
   * @param developerDto the developer dto
   * @return the developer dto
   */
  DeveloperDto createDeveloper(DeveloperDto developerDto);

  /**
   * Find developers list.
   *
   * @return the list
   */
  List<DeveloperDto> findDevelopers();
}
