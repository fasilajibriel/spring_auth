package com.elevateuet.springauth.access.repository;

import com.elevateuet.springauth.access.model.AccessScope;
import java.util.Optional;

public interface AccessScopeRepository {
    Optional<AccessScope> findByName(String name);
    AccessScope save(AccessScope scope);
}
