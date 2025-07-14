package com.elevateuet.springauth.v1.access.repository;

import com.elevateuet.springauth.v1.access.model.ActionPermission;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ActionPermissionRepositoryAdapter implements ActionPermissionRepository {
    private final ActionPermissionJpaRepository jpaRepository;

    public ActionPermissionRepositoryAdapter(ActionPermissionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<ActionPermission> findByName(String name) {
        return jpaRepository.findByName(name);
    }

    @Override
    public ActionPermission save(ActionPermission permission) {
        return jpaRepository.save(permission);
    }
}
