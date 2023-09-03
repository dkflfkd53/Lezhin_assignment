package com.example.lezhinassignment.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    private String userName;

    private String userEmail;

    private String password;

    private String gender;

    private String type;

    private LocalDateTime registerDate;

}
