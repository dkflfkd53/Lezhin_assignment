package com.example.lezhinassignment.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    //user
    USER_NOT_FOUND(404, "User not found"),
    PASSWORD_MISMATCH(404, "Password mismatch"),
    ALREADY_COMMENT(404, "Already write comment"),
    ALREADY_LIKE(404, "Already like"),

    //work
    WORK_NOT_FOUND(404, "Work not found"),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;
}
