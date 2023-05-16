package com.task.learningplatformapi.enums;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    EMAIL_ALREADY_IN_USE("EMAIL_ALREADY_IN_USE", "Email already in use, please enter another one!"),
    STUDENT_UNDER_ALLOWED_AGE("STUDENT_UNDER_ALLOWED_AGE", "Student must be at least 16 years old!");

    private final String code;
    private final String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
