package com.example.lezhinassignment.domain.user.presentation.dto.response;

import com.example.lezhinassignment.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdultUserResponse {

    private Long userId;

    private Long workId;

    private String userName;

    private String gender;

    public AdultUserResponse(User user) {
        userId = user.getId();
        userName = user.getUserName();
        gender = user.getGender();
    }

}