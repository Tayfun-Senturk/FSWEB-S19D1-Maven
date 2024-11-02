package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(PlantException exception){
        log.error("entity exception: ",exception);
        ErrorResponse error = new ErrorResponse(exception.getHttpStatus().value(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error,exception.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception){
        log.error("global exception: ",exception);
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),LocalDateTime.now() );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
