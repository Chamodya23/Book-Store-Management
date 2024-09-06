package com.BookStore.BookStoreManagement.authorservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * GlobalExceptionHandler is a centralized exception handling class for all controllers in the application.
 * It uses Spring's @ControllerAdvice annotation to catch and handle exceptions globally, rather than in each controller.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        // Return a bad request response with the exception's message as the response body
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
