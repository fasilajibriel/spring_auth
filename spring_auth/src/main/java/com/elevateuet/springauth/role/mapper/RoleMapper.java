package com.elevateuet.springauth.role.mapper;

import com.elevateuet.springauth.role.dto.response.RoleResponse;
import com.elevateuet.springauth.role.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponse toResponse(Role role) {
        RoleResponse response = new RoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
