package com.elevateuet.springauth.access.repository;

import com.elevateuet.springauth.access.model.AccessScope;
import com.elevateuet.springauth.access.repository.AccessScopeRepository;
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
