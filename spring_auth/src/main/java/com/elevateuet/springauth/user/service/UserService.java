package com.elevateuet.springauth.user.service;

import com.elevateuet.springauth.user.model.User;
import com.elevateuet.springauth.user.repository.UserRepository;
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
