package com.example.ragchatbot.model;

import java.util.ArrayList;
import java.util.List;

public class Chunk {

    private String content;

    public Chunk(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static List<Chunk> chunkText(String text) {
        // Implement logic to split text into chunks
        List<Chunk> chunks = new ArrayList<>();
        // Placeholder logic
        chunks.add(new Chunk(text));
        return chunks;
    }
}
