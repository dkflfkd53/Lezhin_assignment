package com.example.lezhinassignment.domain.user.service.facade;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import com.example.lezhinassignment.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getName();

        return userRepository.findByUserName(userName)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
