package com.elevateuet.springauth.v1.auth.service;

import com.elevateuet.springauth.v1.auth.dto.request.LoginRequest;
import com.elevateuet.springauth.v1.user.model.User;
import com.elevateuet.springauth.v1.user.repository.UserRepository;
import com.elevateuet.springauth.v1.core.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoSuchElementException("Invalid credentials"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new NoSuchElementException("Invalid credentials");
        }
        return jwtService.generateToken(user);
    }
}
