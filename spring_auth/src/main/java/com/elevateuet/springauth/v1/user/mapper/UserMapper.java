package com.elevateuet.springauth.v1.user.mapper;

import com.elevateuet.springauth.v1.user.dto.response.UserResponse;
import com.elevateuet.springauth.v1.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }
}
