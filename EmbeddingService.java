package com.example.ragchatbot.service;

import com.example.ragchatbot.model.Chunk;
import com.example.ragchatbot.model.Embedding;
import com.zilliz.client.ZillizClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class EmbeddingService {

    private final ZillizClient zillizClient;

    public EmbeddingService() {
        this.zillizClient = new ZillizClient();
    }

    public void processFile(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            processText(text.toString());
        }
    }

    public void processText(String text) {
        List<Chunk> chunks = Chunk.chunkText(text);
        for (Chunk chunk : chunks) {
            Embedding embedding = Embedding.generateEmbedding(chunk.getContent());
            zillizClient.insertEmbedding(embedding);
        }
    }
}
