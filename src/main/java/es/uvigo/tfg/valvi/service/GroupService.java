package es.uvigo.tfg.valvi.service;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GroupDto;
import es.uvigo.tfg.valvi.dto.UserDto;

/**
 * The interface Group service.
 */
public interface GroupService {


  List<GroupDto> findGroups();

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
