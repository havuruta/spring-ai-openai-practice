package com.example.springaiopenai.demo.exception;

public class OpenAIException extends ChatException {
    public OpenAIException(String message) {
        super(message);
    }

    public OpenAIException(String message, Throwable cause) {
        super(message, cause);
    }
} 