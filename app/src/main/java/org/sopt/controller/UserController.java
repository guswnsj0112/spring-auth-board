package org.sopt.controller;


import lombok.RequiredArgsConstructor;

import org.sopt.dto.request.SignupUserRequest;
import org.sopt.entity.User;
import org.sopt.service.UserService;

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
