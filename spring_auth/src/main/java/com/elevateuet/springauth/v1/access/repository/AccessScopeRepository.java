package com.elevateuet.springauth.v1.access.repository;

import com.elevateuet.springauth.v1.access.model.AccessScope;
import java.util.Optional;

public interface AccessScopeRepository {
    Optional<AccessScope> findByName(String name);
    AccessScope save(AccessScope scope);
}
