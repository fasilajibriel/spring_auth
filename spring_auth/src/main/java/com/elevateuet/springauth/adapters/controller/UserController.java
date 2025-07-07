package com.elevateuet.springauth.adapters.controller;

import com.elevateuet.springauth.application.dto.AccessInfoDto;
import com.elevateuet.springauth.application.service.AccessInfoService;
import com.elevateuet.springauth.domain.model.User;
import com.elevateuet.springauth.domain.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/me")
public class UserController {
    private final UserRepository userRepository;
    private final AccessInfoService accessInfoService;

    public UserController(UserRepository userRepository, AccessInfoService accessInfoService) {
        this.userRepository = userRepository;
        this.accessInfoService = accessInfoService;
    }

    @GetMapping("/access-info")
    public List<AccessInfoDto> getAccessInfo(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User user = userRepository.findByEmail(email).orElseThrow();
        return accessInfoService.buildAccessInfo(user);
    }
}
