package com.elevateuet.springauth.v1.role.repository;

import com.elevateuet.springauth.v1.role.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class RoleRepositoryAdapter implements RoleRepository {
    private final RoleJpaRepository jpaRepository;

    public RoleRepositoryAdapter(RoleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return jpaRepository.findByName(name);
    }

    @Override
    public Optional<Role> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public java.util.List<Role> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return jpaRepository.save(role);
    }
}
