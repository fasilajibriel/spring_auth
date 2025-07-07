package com.elevateuet.springauth.adapters.controller;

import com.elevateuet.springauth.domain.model.Role;
import com.elevateuet.springauth.domain.repository.RoleRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RolesController {
    private final RoleRepository roleRepository;

    public RolesController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('view_roles')")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('view_role_detail')")
    public Role getRole(@PathVariable UUID id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create_roles')")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PostMapping("/{id}/permissions")
    @PreAuthorize("hasAuthority('edit_role_permissions')")
    public Role updatePermissions(@PathVariable UUID id, @RequestBody Role role) {
        Role existing = roleRepository.findById(id).orElseThrow();
        existing.setPermissions(role.getPermissions());
        return roleRepository.save(existing);
    }
}
