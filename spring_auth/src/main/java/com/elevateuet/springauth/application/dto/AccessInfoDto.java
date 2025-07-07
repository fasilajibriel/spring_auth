package com.elevateuet.springauth.application.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessInfoDto {
    private String accessScope;
    private List<String> permissions;
}
