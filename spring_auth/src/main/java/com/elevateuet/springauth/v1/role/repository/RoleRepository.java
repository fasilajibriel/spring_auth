package com.elevateuet.springauth.v1.role.repository;

import com.elevateuet.springauth.v1.role.model.Role;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository {
    Optional<Role> findByName(String name);
    Optional<Role> findById(UUID id);
    java.util.List<Role> findAll();
    Role save(Role role);
}
