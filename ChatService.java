package com.example.ragchatbot.service;

import com.example.ragchatbot.model.Embedding;
import com.zilliz.client.ZillizClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ZillizClient zillizClient;

    public String generateResponse(String query) {
        Embedding queryEmbedding = Embedding.generateEmbedding(query);
        Embedding relevantEmbedding = zillizClient.searchEmbedding(queryEmbedding);
        String documentContent = relevantEmbedding.getChunk().getContent();
        String response = callLanguageModel(query, documentContent);
        return response;
    }

    private String callLanguageModel(String query, String context) {
        // Implement API call to language model here
        // Placeholder response for now
        return "Response based on query: " + query + " with context: " + context;
    }
}
