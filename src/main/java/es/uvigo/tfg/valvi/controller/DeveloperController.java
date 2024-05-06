package es.uvigo.tfg.valvi.controller;

import java.util.List;

import es.uvigo.tfg.valvi.dto.DeveloperDto;
import es.uvigo.tfg.valvi.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Developer controller.
 */
@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/developers")
public class DeveloperController {
  
  @Autowired
  private DeveloperService developerService;

  /**
   * Get developers list.
   *
   * @return the list
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<DeveloperDto> getDevelopers(){
    return this.developerService.findDevelopers();
  }

  /**
   * Create developer developer dto.
   *
   * @param developerDto the developer dto
   * @return the developer dto
   */
  @PostMapping
  @ResponseStatus
  public DeveloperDto createDeveloper(@RequestBody DeveloperDto developerDto){
    return this.developerService.createDeveloper(developerDto);
  }
}
