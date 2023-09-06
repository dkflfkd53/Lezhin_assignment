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
    PASSWORD_MISMATCH(403, "Password mismatch"),
    ALREADY_COMMENT(409, "Already write comment"),
    ALREADY_LIKE(409, "Already like"),
    ALREADY_DISLIKE(409, "Already dis_like"),

    //work
    WORK_NOT_FOUND(404, "Work not found"),
    LIKE_NOT_FOUND(404, "Like not found"),
    DIS_LIKE_NOT_FOUND(404, "DisLike not found"),
    COMMENT_NOT_FOUND(404, "Comment not found"),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;

}
