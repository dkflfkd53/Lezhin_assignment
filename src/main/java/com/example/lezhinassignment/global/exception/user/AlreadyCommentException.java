package com.example.lezhinassignment.global.exception.user;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class AlreadyCommentException extends BusinessException {

    public static final BusinessException EXCEPTION = new AlreadyCommentException();

    public AlreadyCommentException() {
        super(ErrorCode.ALREADY_COMMENT);
    }
}
