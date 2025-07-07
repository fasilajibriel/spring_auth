package com.elevateuet.springauth.domain.repository;

import com.elevateuet.springauth.domain.model.AccessScope;
import java.util.Optional;

public interface AccessScopeRepository {
    Optional<AccessScope> findByName(String name);
    AccessScope save(AccessScope scope);
}
