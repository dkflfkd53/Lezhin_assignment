package com.example.lezhinassignment.global.exception.work;

import com.example.lezhinassignment.global.error.exception.BusinessException;
import com.example.lezhinassignment.global.error.exception.ErrorCode;

public class WorkNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new WorkNotFoundException();

    public WorkNotFoundException() {
        super(ErrorCode.WORK_NOT_FOUND);
    }

}
