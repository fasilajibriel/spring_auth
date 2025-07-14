package com.elevateuet.springauth.v1.user.repository;

import com.elevateuet.springauth.v1.user.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    User save(User user);
}
