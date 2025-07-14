package com.elevateuet.springauth.v1.access.service;

import com.elevateuet.springauth.v1.access.dto.AccessInfoDto;
import com.elevateuet.springauth.v1.role.model.Role;
import com.elevateuet.springauth.v1.user.model.User;
import java.util.*;
import java.util.stream.Collectors;

public class AccessInfoService {
    public List<AccessInfoDto> buildAccessInfo(User user) {
        Map<String, Set<String>> data = new HashMap<>();
        for (Role role : user.getRoles()) {
            role.getScopes().forEach(scope ->
                    data.computeIfAbsent(scope.getName(), s -> new HashSet<>()));
            role.getPermissions().forEach(p ->
                    data.values().forEach(perms -> perms.add(p.getName())));
        }
        return data.entrySet().stream()
                .map(e -> new AccessInfoDto(e.getKey(), new ArrayList<>(e.getValue())))
                .collect(Collectors.toList());
    }
}
