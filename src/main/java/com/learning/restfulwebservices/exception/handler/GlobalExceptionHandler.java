package com.learning.restfulwebservices.exception.handler;

import com.learning.restfulwebservices.dto.ExceptionResponse;
import com.learning.restfulwebservices.exception.CustomException;
import com.learning.restfulwebservices.exception.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<ExceptionResponse> handleCustomException(CustomException e) {
        Error error = e.getErrorCode();
        ExceptionResponse response = new ExceptionResponse(error.getCode(), error.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(response, error.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericException(Exception e) {
        ExceptionResponse response = new ExceptionResponse(null, e.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
