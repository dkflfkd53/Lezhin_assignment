package com.example.lezhinassignment.domain.user.service;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.repository.UserRepository;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void deleteUser() {
        User user = userFacade.currentUser();

        userRepository.delete(user);
    }

}
