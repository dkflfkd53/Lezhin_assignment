package com.example.lezhinassignment.global.exception.work;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class DisLikeNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new DisLikeNotFoundException();

    public DisLikeNotFoundException() {
        super(ErrorCode.DIS_LIKE_NOT_FOUND);
    }

}