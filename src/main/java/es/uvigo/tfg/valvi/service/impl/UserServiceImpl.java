package es.uvigo.tfg.valvi.service.impl;

import es.uvigo.tfg.valvi.auth.AuthResponse;
import es.uvigo.tfg.valvi.auth.Role;
import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.mapper.UserMapper;
import es.uvigo.tfg.valvi.repository.UserRepository;
import es.uvigo.tfg.valvi.service.UserService;
import javax.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
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
  
  @NonNull
  private JwtServiceImpl jwtService;

  private final AuthenticationManager authenticationManager;

  private final PasswordEncoder passwordEncoder;
  
  @Override
  public AuthResponse login(UserDto userDto) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
    User user = this.userRepository.findById(userDto.getUsername()).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    String token = this.jwtService.getToken(this.userMapper.toUserDto(user));
    return AuthResponse.builder().token(token).username(userDto.getUsername()).build();
  }

  @Override
  public AuthResponse register(UserDto userDto) {
    User user = User.builder()
            .username(userDto.getUsername())
            .image(userDto.getImage())
            .role(userDto.getRole() == null ? Role.USER : userDto.getRole())
            .password(passwordEncoder.encode(userDto.getPassword()))
            .name(userDto.getName())
            .build();
    
    this.userRepository.save(user);
    return AuthResponse.builder().token(this.jwtService.getToken(userDto)).build();
  }

  @Override
  public UserDto findUser(String username) {
    User user = this.userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    return this.userMapper.toUserDto(user);
  }

  @Override
  public UserDto upsertUser(UserDto userDto) {
    User user = this.userMapper.toUser(userDto);
    if(this.userRepository.findById(user.getUsername()).isPresent()){
      throw new RuntimeException("User already exists");      
    }
    this.userRepository.save(user);
    return userDto;
  }

  @Override
  public String deleteUser(String username) {
    this.userRepository.deleteById(username);
    return username;
  }
}
