package com.task.learningplatformapi.handler;

import com.task.learningplatformapi.exception.CustomException;
import com.task.learningplatformapi.exception.MissingIdToUpdateEntityException;
import com.task.learningplatformapi.exception.StudentUnderAllowedAgeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(StudentUnderAllowedAgeException.class)
    public ResponseEntity<ErrorResponse> handleStudentUnderAllowedAgeException(StudentUnderAllowedAgeException ex) {
        return buildErrorResponse(ex);
    }

    @ExceptionHandler(MissingIdToUpdateEntityException.class)
    public ResponseEntity<ErrorResponse> handleMissingIdToUpdateEntityException(MissingIdToUpdateEntityException ex) {
        return buildErrorResponse(ex);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        HttpStatus httpStatus = resolveHttpStatus(ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    private HttpStatus resolveHttpStatus(CustomException ex) {
        ResponseStatus responseStatus = ex.getClass().getAnnotation(ResponseStatus.class);
        if (responseStatus != null) {
            return responseStatus.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private record ErrorResponse(String message) {
    }
}
