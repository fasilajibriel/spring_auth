package com.elevateuet.springauth.access.repository;

import com.elevateuet.springauth.access.model.ActionPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ActionPermissionJpaRepository extends JpaRepository<ActionPermission, UUID> {
    Optional<ActionPermission> findByName(String name);
}
