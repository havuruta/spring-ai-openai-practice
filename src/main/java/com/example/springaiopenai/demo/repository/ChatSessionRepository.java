package com.example.springaiopenai.demo.repository;

import com.example.springaiopenai.demo.model.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, String> {
} 