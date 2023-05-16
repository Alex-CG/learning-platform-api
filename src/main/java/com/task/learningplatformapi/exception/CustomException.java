package com.task.learningplatformapi.exception;

import com.task.learningplatformapi.enums.ErrorCodes;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ErrorCodes errorCode;
    private final String entity;
    private final String field;

    public CustomException(ErrorCodes errorCode, String entity, String field) {
        super();
        this.errorCode = errorCode;
        this.entity = entity;
        this.field = field;
    }

    public CustomException(ErrorCodes errorCode) {
        this(errorCode, null, null);
    }
}
