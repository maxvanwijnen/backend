package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.exception.BadRequestException;
import com.eindopdracht.eindopdracht.exception.DuplicateException;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<String> handleDuplicateException(DuplicateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestException(BadRequestException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
