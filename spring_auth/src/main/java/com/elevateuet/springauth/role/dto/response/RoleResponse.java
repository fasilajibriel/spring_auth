package com.elevateuet.springauth.role.dto.response;

import lombok.Data;
import java.util.UUID;

@Data
public class RoleResponse {
    private UUID id;
    private String name;
}
