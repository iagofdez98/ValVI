package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.mapper.UserMapper;
import es.uvigo.tfg.valvi.repository.UserRepository;
import es.uvigo.tfg.valvi.service.UserService;
import javax.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type User service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  @NonNull
  private UserRepository userRepository;

  @NonNull
  private UserMapper userMapper;
  
  @Override
  public UserDto findUser(String username) {
    User user = this.userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    return this.userMapper.toUserDto(user);
  }

  @Override
  public UserDto upsertUser(UserDto userDto) {
    User user = this.userRepository.save(this.userMapper.toUser(userDto));
    return this.userMapper.toUserDto(user);
  }

  @Override
  public String deleteUser(String username) {
    this.userRepository.deleteById(username);
    return username;
  }
}
