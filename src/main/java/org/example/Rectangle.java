package org.example;


public class Rectangle extends Shape {
    private double x, y;
    public Rectangle(Colour color, double x, double y) {
        super(color);
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return x * y;
    }

    @Override
    public double getPerimeter() {
        return 2 * (x + y);
    }
}