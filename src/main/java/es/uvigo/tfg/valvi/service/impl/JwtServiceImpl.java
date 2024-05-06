package es.uvigo.tfg.valvi.service.impl;

import es.uvigo.tfg.valvi.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class JwtServiceImpl {
    
    private static final String SECRET_KEY = "ZSJvmNP1qf5xgLIiDwfwwwtODCG6i1br4eJDztYZs4Q";
    
    public String getToken(UserDto userDto) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDto.getUsername());
        claims.put("password", userDto.getPassword());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDto.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    private Key getKey() {
        byte[] key = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(key);
    }
    
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    
    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }
}
