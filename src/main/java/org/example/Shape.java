package org.example;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shape_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Colour color;

    public Shape(Colour color) {
        this.color = color;
    }

    public Shape() {}

    public Colour getColor() {
        return color;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public String getColorDescription() {
        return String.format("Red: %d, Green: %d, Blue: %d, Alpha: %d",
                color.red(), color.green(), color.blue(), color.alpha());
    }
    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }
}
