package com.task.learningplatformapi.handler;

import com.task.learningplatformapi.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler(MissingIdToPersistEntityException.class)
    public ResponseEntity<ErrorResponse> handleMissingIdToUpdateEntityException(MissingIdToPersistEntityException ex) {
        return buildErrorResponse(ex);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        CustomException customEx = null;
        if (ex.getMessage().contains("student_email_key")) {
            customEx = new EmailAlreadyInUseException();
        }
        return buildErrorResponse(customEx);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getErrorCode().getCode(), ex.getErrorCode().getMessage(),
                ex.getEntity(), ex.getField());
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

    private record ErrorResponse(String code, String message, String entity, String field) {
    }
}
