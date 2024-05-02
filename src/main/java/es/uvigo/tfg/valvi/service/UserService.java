package es.uvigo.tfg.valvi.service;

import es.uvigo.tfg.valvi.dto.UserDto;

/**
 * The interface User service.
 */
public interface UserService {

  boolean authenticate(UserDto userDto);

  /**
   * Find user user dto.
   *
   * @param username the username
   * @return the user dto
   */
  UserDto findUser(String username);

  /**
   * Upsert user user dto.
   *
   * @param userDto the user dto
   * @return the user dto
   */
  UserDto upsertUser(UserDto userDto);

  /**
   * Delete user string.
   *
   * @param username the username
   * @return the string
   */
  String deleteUser(String username);
}
