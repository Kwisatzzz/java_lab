package org.example;

public abstract class Shape {
    private final Colour color;
    public Shape(Colour color) {
        this.color = color;
    }
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
