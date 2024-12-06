package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "rectangles")
public class Rectangle extends Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double x, y;
    public Rectangle(Colour color, double x, double y) {
        super(color);
        this.x = x;
        this.y = y;
    }

    public Rectangle() {
        super();
    }

    @Override
    public double getArea() {
        return x * y;
    }

    @Override
    public double getPerimeter() {
        return 2 * (x + y);
    }

    public Long getId() {
        return id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}