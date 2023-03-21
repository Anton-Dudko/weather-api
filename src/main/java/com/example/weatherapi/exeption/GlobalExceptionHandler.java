package com.example.weatherapi.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDetails> handleInternalServer(Throwable e) {
        return build(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> handleInternalServer(RuntimeException e) {
        return build(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDetails> build(String message, HttpStatus status) {
        log.error("Error msg: {}", message);
        return new ResponseEntity<>(ErrorDetails.builder()
                .message(message)
                .status(status.name())
                .createdAt(LocalDateTime.now())
                .build(),
                status);
    }
}
