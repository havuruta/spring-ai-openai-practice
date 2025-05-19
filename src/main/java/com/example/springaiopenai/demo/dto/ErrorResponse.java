package com.example.springaiopenai.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private final LocalDateTime timestamp;
    private final String message;
    private final String errorCode;
    private final String path;

    public static ErrorResponse of(String message, String errorCode, String path) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(message)
                .errorCode(errorCode)
                .path(path)
                .build();
    }
} 