package com.elevateuet.springauth.role.controller;

import com.elevateuet.springauth.role.dto.response.RoleResponse;
import com.elevateuet.springauth.role.mapper.RoleMapper;
import com.elevateuet.springauth.role.model.Role;
import com.elevateuet.springauth.role.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RolesController {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public RolesController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('view_roles')")
    public List<RoleResponse> getRoles() {
        return roleService.findAll().stream().map(roleMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('view_role_detail')")
    public Role getRole(@PathVariable UUID id) {
        return roleService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create_roles')")
    public Role createRole(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PostMapping("/{id}/permissions")
    @PreAuthorize("hasAuthority('edit_role_permissions')")
    public Role updatePermissions(@PathVariable UUID id, @RequestBody Role role) {
        Role existing = roleService.findById(id);
        existing.setPermissions(role.getPermissions());
        return roleService.save(existing);
    }
}
