package es.uvigo.tfg.valvi.controller;

import java.io.IOException;
import java.util.List;

import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.dto.filters.VideogameFiltering;
import es.uvigo.tfg.valvi.service.VideogameService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Videogame controller.
 */
@Validated
@RestController
@RequestMapping(path = "/videogames")
public class VideogameController {
    
    @Autowired
    private VideogameService videogameService;

    /**
     * Find videogames list.
     *
     * @param videogameFiltering the videogame filtering
     * @return the list
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VideogameDto> findVideogames(VideogameFiltering videogameFiltering){
        return this.videogameService.findVideogames(videogameFiltering);
    }
    
    @GetMapping("/steamapi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VideogameDto getSteamVideogame(@PathVariable Integer id) throws IOException {
        return this.videogameService.getSteamVideogame(id);
    }

    /**
     * Upsert videogame videogame dto.
     *
     * @param videogameDto the videogame dto
     * @return the videogame dto
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VideogameDto upsertVideogame(@RequestBody @NonNull VideogameDto videogameDto){
        return this.videogameService.upsertVideogame(videogameDto);
    }

    /**
     * Delete videogame integer.
     *
     * @param id the id
     * @return the integer
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer deleteVideogame(Integer id){
        return this.videogameService.deleteVideogame(id);
    }
    
}
