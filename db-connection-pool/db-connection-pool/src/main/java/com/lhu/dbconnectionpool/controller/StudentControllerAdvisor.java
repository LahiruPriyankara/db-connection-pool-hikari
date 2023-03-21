package com.lhu.dbconnectionpool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentControllerAdvisor {

    @ExceptionHandler(RuntimeException.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<String> handleException(
            final RuntimeException exception) {
        return ResponseEntity.ok(exception.getMessage());
    }

}
