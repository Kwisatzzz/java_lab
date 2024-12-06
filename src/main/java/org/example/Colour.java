package org.example;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class Colour {
    @Column(nullable = false)
    private int red;

    @Column(nullable = false)
    private int green;

    @Column(nullable = false)
    private int blue;

    @Column(nullable = false)
    private int alpha;

    public Colour() {}

    public Colour(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Colour(int red, int green, int blue) {
        this(red, green, blue, 0);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }
}
