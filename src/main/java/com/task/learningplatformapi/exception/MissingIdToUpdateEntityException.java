package com.task.learningplatformapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingIdToUpdateEntityException extends CustomException {

    public MissingIdToUpdateEntityException(String message) {
        super(message);
    }
}
