package com.example.lezhinassignment.global.exception.token;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }

}
