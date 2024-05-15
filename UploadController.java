package com.example.ragchatbot.controller;

import com.example.ragchatbot.service.EmbeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private EmbeddingService embeddingService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        embeddingService.processFile(file);
        return ResponseEntity.ok("File uploaded and processed successfully");
    }

    @PostMapping("/upload-text")
    public ResponseEntity<String> uploadText(@RequestBody String text) {
        embeddingService.processText(text);
        return ResponseEntity.ok("Text uploaded and processed successfully");
    }
}
