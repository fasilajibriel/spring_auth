package com.elevateuet.springauth.v1.access.repository;

import com.elevateuet.springauth.v1.access.model.AccessScope;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccessScopeRepositoryAdapter implements AccessScopeRepository {
    private final AccessScopeJpaRepository jpaRepository;

    public AccessScopeRepositoryAdapter(AccessScopeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<AccessScope> findByName(String name) {
        return jpaRepository.findByName(name);
    }

    @Override
    public AccessScope save(AccessScope scope) {
        return jpaRepository.save(scope);
    }
}
