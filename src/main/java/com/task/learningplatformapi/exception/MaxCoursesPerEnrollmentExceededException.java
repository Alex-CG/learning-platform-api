package com.task.learningplatformapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaxCoursesPerEnrollmentExceededException extends CustomException {

    public MaxCoursesPerEnrollmentExceededException(String message) {
        super(message);
    }
}
