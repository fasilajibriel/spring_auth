package com.elevateuet.springauth.role.repository;

import com.elevateuet.springauth.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleJpaRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
