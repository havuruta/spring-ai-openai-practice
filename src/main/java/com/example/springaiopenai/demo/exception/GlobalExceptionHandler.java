package com.example.springaiopenai.demo.exception;

import com.example.springaiopenai.demo.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OpenAIException.class)
    public ResponseEntity<ErrorResponse> handleOpenAIException(OpenAIException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(ErrorResponse.of(
                        ex.getMessage(),
                        "OPENAI_ERROR",
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(SessionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSessionNotFoundException(SessionNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(
                        ex.getMessage(),
                        "SESSION_NOT_FOUND",
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(ChatException.class)
    public ResponseEntity<ErrorResponse> handleChatException(ChatException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(
                        ex.getMessage(),
                        "CHAT_ERROR",
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(
                        "An unexpected error occurred",
                        "INTERNAL_SERVER_ERROR",
                        request.getRequestURI()
                ));
    }
} 