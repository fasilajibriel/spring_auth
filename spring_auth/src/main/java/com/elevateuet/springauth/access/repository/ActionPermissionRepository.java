package com.elevateuet.springauth.access.repository;

import com.elevateuet.springauth.access.model.ActionPermission;
import java.util.Optional;

public interface ActionPermissionRepository {
    Optional<ActionPermission> findByName(String name);
    ActionPermission save(ActionPermission permission);
}
