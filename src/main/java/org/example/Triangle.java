package org.example;

import jakarta.persistence.*;
import org.hibernate.engine.transaction.internal.TransactionImpl;

@Entity
@DiscriminatorValue("Triangle")
public class Triangle extends Shape {
    private double x, y, z;

    public Triangle(Colour color, double x, double y, double z) {
        super(color);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Triangle() {}

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }

    @Override
    public double getPerimeter() {
        return x + y + z;
    }
}