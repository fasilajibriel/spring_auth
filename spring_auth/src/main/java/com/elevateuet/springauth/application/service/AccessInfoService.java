package com.elevateuet.springauth.application.service;

import com.elevateuet.springauth.application.dto.AccessInfoDto;
import com.elevateuet.springauth.domain.model.Role;
import com.elevateuet.springauth.domain.model.User;
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
