package org.sopt.auth.controller;


import lombok.RequiredArgsConstructor;

import org.sopt.auth.dto.request.SignupUserRequest;
import org.sopt.auth.entity.User;
import org.sopt.auth.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/signup")
    public User signup(@RequestBody SignupUserRequest request) {
        User saveUser = userService.register(request);

        return saveUser;
    }
}
