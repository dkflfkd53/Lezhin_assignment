package com.example.lezhinassignment.global.exception.user;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class AlreadyLikeException extends BusinessException {

    public static final BusinessException EXCEPTION = new AlreadyLikeException();

    public AlreadyLikeException() {
        super(ErrorCode.ALREADY_LIKE);
    }
}