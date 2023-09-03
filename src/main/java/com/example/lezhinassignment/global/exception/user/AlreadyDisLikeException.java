package com.example.lezhinassignment.global.exception.user;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class AlreadyDisLikeException extends BusinessException {

    public static final BusinessException EXCEPTION = new AlreadyDisLikeException();

    public AlreadyDisLikeException() {
        super(ErrorCode.ALREADY_DISLIKE);
    }
}