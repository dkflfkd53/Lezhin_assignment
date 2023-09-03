package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.presentation.dto.response.AdultUserResponse;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAdultUserService {

    private final UserRepository userRepository;

    public List<AdultUserResponse> getAdultUser() {
        List<User> adultUser = userRepository.findAll()
                .stream()
                .filter(e ->e.getAdultWork().stream().distinct().count()>=3)
                .collect(Collectors.toList());

        return adultUser
                .stream()
                .map(AdultUserResponse::new)
                .collect(Collectors.toList());
    }
}