package es.uvigo.tfg.valvi.controller;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GroupDto;
import es.uvigo.tfg.valvi.service.GroupService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The type Group controller.
 */
@Validated
@RestController
@RequestMapping(path = "/groups")
public class GroupController {
  
  @Autowired
  private GroupService groupService;

  /**
   * Find groups list.
   *
   * @param username    the username
   * @param videogameId the videogame id
   * @return the list
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<GroupDto> findGroups(@RequestBody String username, @RequestBody Integer videogameId){
    return this.groupService.findGroups(username, videogameId);
  }

  /**
   * Upsert group group dto.
   *
   * @param groupDto the group dto
   * @return the group dto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GroupDto upsertGroup(@RequestBody @NonNull GroupDto groupDto){
    return this.groupService.upsertGroup(groupDto);
  }

  /**
   * Delete group integer.
   *
   * @param id the id
   * @return the integer
   */
  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public Integer deleteGroup(@NonNull Integer id){
    return this.groupService.deleteGroup(id);
  }
}