package com.example.restfulwebservice.exception;

import com.example.restfulwebservice.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public final ExceptionResponse handleUserNotFoundException(Exception ex, WebRequest request) {
        return new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
    }

    /**
     * 모든 예외 처리
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public final ExceptionResponse handleAllExceptions(Exception ex, WebRequest request) {
        return new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
    }
}
