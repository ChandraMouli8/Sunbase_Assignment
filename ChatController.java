package com.example.ragchatbot.controller;

import com.example.ragchatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String query) {
        String response = chatService.generateResponse(query);
        return ResponseEntity.ok(response);
    }
}
