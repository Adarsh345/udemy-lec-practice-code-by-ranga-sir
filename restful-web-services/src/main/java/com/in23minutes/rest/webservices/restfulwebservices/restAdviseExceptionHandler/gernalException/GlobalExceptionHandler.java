package com.in23minutes.rest.webservices.restfulwebservices.restAdviseExceptionHandler.gernalException;

import com.in23minutes.rest.webservices.restfulwebservices.user.model.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        GaneralException ganeralException = new GaneralException(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity(ganeralException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
        GaneralException ganeralException = new GaneralException(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity(ganeralException, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
         GaneralException exception = new GaneralException(LocalDateTime.now(),"Total error are " + ex.getErrorCount() +
                 "and the first error is "+ex.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exception , HttpStatus.BAD_REQUEST);
    }


}
