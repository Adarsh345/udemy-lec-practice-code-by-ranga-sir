package com.in23minutes.rest.webservices.restfulwebservices.restAdviseExceptionHandler.gernalException;

import com.in23minutes.rest.webservices.restfulwebservices.user.model.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHendler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GaneralException userNotFoundExceptionalHandler(UserNotFoundException userNotFoundException){
        return new GaneralException(LocalDateTime.now(), userNotFoundException.getMessage());
    }
}
