package com.example.lezhinassignment.domain.user.presentation.dto.response;

import com.example.lezhinassignment.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String userName;

    private String gender;

    private LocalDateTime visitTime;

    public UserResponse(User user) {
        id = user.getId();
        userName = user.getUserName();
        gender = user.getGender();
        visitTime = user.getVisitTime();
    }

}
