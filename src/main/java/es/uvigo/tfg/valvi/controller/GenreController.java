package es.uvigo.tfg.valvi.controller;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GenreDto;
import es.uvigo.tfg.valvi.service.GenreService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Genre controller.
 */
@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/genres")
public class GenreController {
  
  @Autowired
  private GenreService genreService;

  /**
   * Get genres list.
   *
   * @return the list
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<GenreDto> getGenres(){
    return this.genreService.getGenres();
  }

  /**
   * Create genre genre dto.
   *
   * @param genreDto the genre dto
   * @return the genre dto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GenreDto createGenre(@RequestBody GenreDto genreDto){
    return this.genreService.createGenre(genreDto);
  }
}
