package com.elevateuet.springauth.v1.core.security;

import com.elevateuet.springauth.v1.role.model.Role;
import com.elevateuet.springauth.v1.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final SecretKey key;
    private final long expirationMs;

    public JwtService(@Value("${app.jwt.secret:secret-key-123456789012345678901234567890}") String secret,
                      @Value("${app.jwt.expiration:3600000}") long expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }

    public String generateToken(User user) {
        String roles = user.getRoles().stream().map(Role::getName).collect(Collectors.joining(","));
        return Jwts.builder()
                .subject(user.getId().toString())
                .claim("roles", roles)
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    public UUID getUserId(String token) {
        return UUID.fromString(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject());
    }

    public String getRoles(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("roles", String.class);
    }
}
