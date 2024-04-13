package com.ashishtomar.resultpedia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {



    // To handle StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundExceptionHandler(StudentNotFoundException ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getLocalizedMessage());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }



    // To handle CourseNotFoundException
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorMessage> courseNotFoundExceptionHandler(CourseNotFoundException ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getLocalizedMessage());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }



    // To handle ResultNotFoundException
    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<ErrorMessage> resultNotFoundExceptionHandler(ResultNotFoundException ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getLocalizedMessage());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }



    // To handle UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> userNotFoundExceptionHandler(UserNotFoundException ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getLocalizedMessage());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler
    public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {

        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), fieldError.getField() + ": " + fieldError.getDefaultMessage());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }



    // To handle all other types of exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now(), ex.getLocalizedMessage());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
