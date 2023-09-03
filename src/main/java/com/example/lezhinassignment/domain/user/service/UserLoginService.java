package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.presentation.dto.request.LoginRequest;
import com.example.lezhinassignment.domain.user.presentation.dto.response.TokenResponse;
import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import com.example.lezhinassignment.global.exception.user.PasswordMismatchException;
import com.example.lezhinassignment.global.exception.user.UserNotFoundException;
import com.example.lezhinassignment.global.security.jwt.JwtProperties;
import com.example.lezhinassignment.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    public TokenResponse login(@Valid LoginRequest request) {

        Date now = new Date();

        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserName()))
                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration()))
                .build();

    }

}
