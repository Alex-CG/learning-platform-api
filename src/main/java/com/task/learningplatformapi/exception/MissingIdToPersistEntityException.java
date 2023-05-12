package com.task.learningplatformapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingIdToPersistEntityException extends CustomException {

    public MissingIdToPersistEntityException(String message) {
        super(message);
    }
}
