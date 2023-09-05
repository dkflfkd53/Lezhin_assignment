package com.example.lezhinassignment.global.exception.work;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class CommentNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new CommentNotFoundException();

    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }

}