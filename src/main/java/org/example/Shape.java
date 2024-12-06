package org.example;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Colour color;

    public Shape() {}

    public Shape(Colour color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public Colour getColor() {
        return color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColorDescription() {
        return String.format("Red: %d, Green: %d, Blue: %d, Alpha: %d",
                color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }
}
