package com.elevateuet.springauth.access.repository;

import com.elevateuet.springauth.access.model.ActionPermission;
import com.elevateuet.springauth.access.repository.ActionPermissionRepository;
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
