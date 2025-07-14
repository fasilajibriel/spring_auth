package com.elevateuet.springauth.v1.access.repository;

import com.elevateuet.springauth.v1.access.model.ActionPermission;
import java.util.Optional;

public interface ActionPermissionRepository {
    Optional<ActionPermission> findByName(String name);
    ActionPermission save(ActionPermission permission);
}
