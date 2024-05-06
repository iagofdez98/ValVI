package es.uvigo.tfg.valvi.controller;

import es.uvigo.tfg.valvi.auth.AuthResponse;
import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final UserService userService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.userService.login(userDto));
    }
    
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.userService.register(userDto));
    }
    
}
