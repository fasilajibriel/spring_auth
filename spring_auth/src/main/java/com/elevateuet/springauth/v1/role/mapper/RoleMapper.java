package com.elevateuet.springauth.v1.role.mapper;

import com.elevateuet.springauth.v1.role.dto.response.RoleResponse;
import com.elevateuet.springauth.v1.role.model.Role;
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
