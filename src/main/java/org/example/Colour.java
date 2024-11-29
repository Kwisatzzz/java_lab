package org.example;

public record Colour(int red, int green, int blue, int alpha) {
    public Colour(int red, int green, int blue) {
        this(red, green, blue, 0);
    }
}