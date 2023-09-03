package com.example.lezhinassignment.domain.user.presentation;

import com.example.lezhinassignment.domain.user.presentation.dto.request.LoginRequest;
import com.example.lezhinassignment.domain.user.presentation.dto.request.SignupRequest;
import com.example.lezhinassignment.domain.user.presentation.dto.response.AdultUserResponse;
import com.example.lezhinassignment.domain.user.presentation.dto.response.TokenResponse;
import com.example.lezhinassignment.domain.user.service.DeleteUserService;
import com.example.lezhinassignment.domain.user.service.GetAdultUserService;
import com.example.lezhinassignment.domain.user.service.UserLoginService;
import com.example.lezhinassignment.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignupService userSignupService;
    private final UserLoginService userLoginService;
    private final GetAdultUserService getAdultUserService;
    private final DeleteUserService deleteUserService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody SignupRequest request) {
        userSignupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginRequest request) {
        return userLoginService.login(request);
    }

    @GetMapping("/adult-user")
    public List<AdultUserResponse> getAdultUser() {
        return getAdultUserService.getAdultUser();
    }

    @DeleteMapping("/user")
    public void deleteUser() {
        deleteUserService.deleteUser();
    }

}
