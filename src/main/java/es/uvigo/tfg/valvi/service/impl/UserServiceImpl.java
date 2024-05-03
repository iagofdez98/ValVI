package es.uvigo.tfg.valvi.service.impl;

import static javax.crypto.Cipher.SECRET_KEY;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.mapper.UserMapper;
import es.uvigo.tfg.valvi.repository.UserRepository;
import es.uvigo.tfg.valvi.service.UserService;
import javax.persistence.EntityNotFoundException;

import es.uvigo.tfg.valvi.utils.PasswordToKeyConverter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
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
  public Map<String, String> authenticate(String username, String password) {
    Map<String, String> response = new HashMap<>();
    if(this.userRepository.findByUsernameAndPassword(username, password).isPresent()) {
      response.put("token", generateToken(username));
    } else {
      throw new RuntimeException("Invalid credentials");
    }
    return response;
  }

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

  private String generateToken(String username) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + 3600000); // 1 hora de duración del token

    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, "secretkey")
            .compact();
  }
  
  // Función para verificar si la contraseña proporcionada es válida
  public boolean verifyPassword(String enteredPassword, byte[] storedKey, byte[] salt) throws NoSuchAlgorithmException {
    byte[] enteredKey = PasswordToKeyConverter.convertPasswordToKey(enteredPassword, salt);
    // Comparar la clave derivada de la contraseña proporcionada con la clave almacenada en la base de datos
    return MessageDigest.isEqual(enteredKey, storedKey);
  }
}
