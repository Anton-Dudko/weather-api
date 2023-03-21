package com.example.weatherapi.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleInternalServer(Throwable e) {
        return build(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorDetails> build(String message, HttpStatus status) {
        log.error("Error msg: {}", message);
        return new ResponseEntity<>(ErrorDetails.builder().message(message).build(),
                status);
    }
}
