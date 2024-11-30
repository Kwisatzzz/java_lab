package org.example;

import jakarta.persistence.*;

@Embeddable
public record Colour(int red, int green, int blue, int alpha) {
    public Colour(int red, int green, int blue) {
        this(red, green, blue, 0);
    }
}