package com.example.springaiopenai.demo.repository;

import com.example.springaiopenai.demo.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatSession_SessionIdOrderByCreatedAtAsc(String sessionId);
} 