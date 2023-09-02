package com.example.lezhinassignment.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class TokenResponse {
    private String accessToken;

    private Date accessExpiredAt;
}

