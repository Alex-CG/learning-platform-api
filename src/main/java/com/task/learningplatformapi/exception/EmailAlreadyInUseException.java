package com.task.learningplatformapi.exception;

import com.task.learningplatformapi.enums.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyInUseException extends CustomException {

    public EmailAlreadyInUseException() {
        super(ErrorCodes.EMAIL_ALREADY_IN_USE, "student", "email");
    }
}
