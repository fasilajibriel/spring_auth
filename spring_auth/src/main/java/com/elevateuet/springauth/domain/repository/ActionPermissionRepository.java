package com.elevateuet.springauth.domain.repository;

import com.elevateuet.springauth.domain.model.ActionPermission;
import java.util.Optional;

public interface ActionPermissionRepository {
    Optional<ActionPermission> findByName(String name);
    ActionPermission save(ActionPermission permission);
}
