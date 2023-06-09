package com.task.learningplatformapi.exception;

import com.task.learningplatformapi.enums.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentUnderAllowedAgeException extends CustomException {

    public StudentUnderAllowedAgeException() {
        super(ErrorCodes.STUDENT_UNDER_ALLOWED_AGE, "student", "dob");
    }
}
