package com.example.lezhinassignment.global.exception.user;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}
