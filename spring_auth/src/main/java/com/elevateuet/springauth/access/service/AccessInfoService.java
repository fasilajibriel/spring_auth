package com.elevateuet.springauth.access.service;

import com.elevateuet.springauth.access.dto.AccessInfoDto;
import com.elevateuet.springauth.role.model.Role;
import com.elevateuet.springauth.user.model.User;
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
