package com.elevateuet.springauth.infrastructure.persistence;

import com.elevateuet.springauth.domain.model.AccessScope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccessScopeJpaRepository extends JpaRepository<AccessScope, UUID> {
    Optional<AccessScope> findByName(String name);
}
