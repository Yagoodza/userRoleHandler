package com.yagudza.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final String NO_USER = "There is no such user";


    @ExceptionHandler (UserNotFoundException.class)
    public ResponseEntity<String> userNotFound() {
        return new ResponseEntity<>(NO_USER, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}
