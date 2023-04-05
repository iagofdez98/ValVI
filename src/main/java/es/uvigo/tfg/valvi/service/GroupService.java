package es.uvigo.tfg.valvi.service;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GroupDto;
import es.uvigo.tfg.valvi.dto.UserDto;

/**
 * The interface Group service.
 */
public interface GroupService {

  /**
   * Find groups list.
   *
   * @param username    the username
   * @param videogameId the videogame id
   * @return the list
   */
  List<GroupDto> findGroups(String username, Integer videogameId);

  /**
   * Upsert group group dto.
   *
   * @param groupDto the group dto
   * @return the group dto
   */
  GroupDto upsertGroup(GroupDto groupDto);

  /**
   * Delete group integer.
   *
   * @param id the id
   * @return the integer
   */
  Integer deleteGroup(Integer id);
}
