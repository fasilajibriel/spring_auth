package com.elevateuet.springauth.v1.user.controller;

import com.elevateuet.springauth.v1.access.dto.AccessInfoDto;
import com.elevateuet.springauth.v1.access.service.AccessInfoService;
import com.elevateuet.springauth.v1.user.dto.response.UserResponse;
import com.elevateuet.springauth.v1.user.mapper.UserMapper;
import com.elevateuet.springauth.v1.user.model.User;
import com.elevateuet.springauth.v1.user.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/me")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AccessInfoService accessInfoService;

    public UserController(UserService userService, UserMapper userMapper, AccessInfoService accessInfoService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.accessInfoService = accessInfoService;
    }

    @GetMapping
    public UserResponse getMe(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User user = userService.findByEmail(email);
        return userMapper.toResponse(user);
    }

    @GetMapping("/access-info")
    public List<AccessInfoDto> getAccessInfo(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User user = userService.findByEmail(email);
        return accessInfoService.buildAccessInfo(user);
    }
}
