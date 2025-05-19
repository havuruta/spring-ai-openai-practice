package com.example.springaiopenai.demo.controller;

import com.example.springaiopenai.demo.model.ChatMessage;
import com.example.springaiopenai.demo.model.ChatSession;
import com.example.springaiopenai.demo.service.ChatService;
import com.example.springaiopenai.demo.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    private final OpenAIService openAIService;

    @PostMapping("/session")
    public ResponseEntity<ChatSession> createSession(@RequestParam(required = false, defaultValue = "") String title) {
        return ResponseEntity.ok(chatService.createSession(title));
    }

    @PostMapping("/{sessionId}/message")
    public ResponseEntity<ChatMessage> sendMessage(
            @PathVariable String sessionId,
            @RequestParam String content) {
        ChatSession session = chatService.getSession(sessionId);
        // 사용자 메시지 저장
        chatService.saveMessage(session, ChatMessage.MessageRole.USER, content);
        // OpenAI 응답 생성
        String reply = openAIService.getAssistantReply(sessionId, content);
        // assistant 메시지 저장
        ChatMessage assistantMsg = chatService.saveMessage(session, ChatMessage.MessageRole.ASSISTANT, reply);
        return ResponseEntity.ok(assistantMsg);
    }

    @GetMapping("/{sessionId}/messages")
    public ResponseEntity<List<ChatMessage>> getMessages(@PathVariable String sessionId) {
        return ResponseEntity.ok(chatService.getMessages(sessionId));
    }
} 