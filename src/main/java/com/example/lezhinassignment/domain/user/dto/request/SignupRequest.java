package com.example.lezhinassignment.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    @NotNull
    private String userName;

    @NotNull
    private String userEmail;

    @NotNull
    private String password;

    @NotNull
    private String gender;

    @NotNull
    private String type;

    @NotNull
    private LocalDateTime registerDate;

}
