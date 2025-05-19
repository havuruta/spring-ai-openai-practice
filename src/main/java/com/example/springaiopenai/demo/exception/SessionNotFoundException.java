package com.example.springaiopenai.demo.exception;

public class SessionNotFoundException extends ChatException {
    public SessionNotFoundException(String sessionId) {
        super("Chat session not found: " + sessionId);
    }
} 