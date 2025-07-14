package com.elevateuet.springauth.role.service;

import com.elevateuet.springauth.role.model.Role;
import com.elevateuet.springauth.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(java.util.UUID id) {
        return roleRepository.findById(id).orElseThrow();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
