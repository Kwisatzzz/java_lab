package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "triangles")
public class Triangle extends Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double x, y, z;
    public Triangle(Colour color, double x, double y, double z) {
        super(color);
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Triangle() {
        super();
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }

    @Override
    public double getPerimeter() {
        return x + y + z;
    }

    public Long getId() {
        return id;
    }

}