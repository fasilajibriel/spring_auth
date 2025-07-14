package com.elevateuet.springauth.v1.user.service;

import com.elevateuet.springauth.v1.user.model.User;
import com.elevateuet.springauth.v1.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }
}
