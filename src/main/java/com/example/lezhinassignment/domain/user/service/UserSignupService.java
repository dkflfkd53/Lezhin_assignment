package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.dto.request.SignupRequest;
import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        String password = passwordEncoder.encode(request.getPassword());

        userRepository.save(
                User.builder()
                        .userName(request.getUserName())
                        .userEmail(request.getUserEmail())
                        .password(password)
                        .gender(request.getGender())
                        .type(request.getType())
                        .registerDate(request.getRegisterDate())
                        .build());
    }

}
