package com.example.lezhinassignment.domain.user.controller;

import com.example.lezhinassignment.domain.user.dto.request.LoginRequest;
import com.example.lezhinassignment.domain.user.dto.request.SignupRequest;
import com.example.lezhinassignment.domain.user.dto.response.TokenResponse;
import com.example.lezhinassignment.domain.user.service.UserLoginService;
import com.example.lezhinassignment.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignupService userSignupService;
    private final UserLoginService userLoginService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody SignupRequest request) {
        userSignupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginRequest request) {
        return userLoginService.login(request);
    }

}
