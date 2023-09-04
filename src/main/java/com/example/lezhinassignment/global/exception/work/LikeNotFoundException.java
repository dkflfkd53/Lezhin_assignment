package com.example.lezhinassignment.global.exception.work;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class LikeNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new LikeNotFoundException();

    public LikeNotFoundException() {
        super(ErrorCode.LIKE_NOT_FOUND);
    }

}
