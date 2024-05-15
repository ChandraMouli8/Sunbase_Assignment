package com.example.ragchatbot.model;

public class Embedding {

    private Chunk chunk;
    private float[] vector;

    public Embedding(Chunk chunk, float[] vector) {
        this.chunk = chunk;
        this.vector = vector;
    }

    public Chunk getChunk() {
        return chunk;
    }

    public float[] getVector() {
        return vector;
    }

    public static Embedding generateEmbedding(String text) {
        // Implement logic to generate embedding from text
        // Placeholder embedding
        float[] vector = new float[]{0.1f, 0.2f, 0.3f};
        return new Embedding(new Chunk(text), vector);
    }
}
