package com.example.lezhinassignment.domain.user.controller;

import com.example.lezhinassignment.domain.user.dto.request.SignupRequest;
import com.example.lezhinassignment.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignupService userLoginService;

    @PostMapping("/signup")
    public void signup(@Valid SignupRequest request) {
        userLoginService.signup(request);
    }
}
