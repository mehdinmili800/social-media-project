package com.mehdi.socialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobelExeptions {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetais> userExceptionHandler(UserException ue, WebRequest req){

        ErrorDetais error = new ErrorDetais(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDetais>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetais> otherExceptionHandler(Exception ue, WebRequest req){

        ErrorDetais error = new ErrorDetais(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDetais>(error, HttpStatus.BAD_REQUEST);
    }
}
