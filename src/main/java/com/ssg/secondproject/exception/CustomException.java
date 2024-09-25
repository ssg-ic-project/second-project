package com.ssg.secondproject.exception;

import com.ssg.secondproject.common.ErrorCode;

public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
