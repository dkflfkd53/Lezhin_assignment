package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.presentation.dto.response.AdultUserResponse;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import com.example.lezhinassignment.domain.work.entity.Visit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAdultUserService {

    private final UserRepository userRepository;

    public List<AdultUserResponse> getAdultUser() {
        return userRepository.getAdultUser()
                .stream()
                .map(AdultUserResponse::new)
                .collect(Collectors.toList());
    }

}
