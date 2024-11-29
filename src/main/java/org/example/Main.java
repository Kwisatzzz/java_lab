package org.example;

public class Main {
    public static void main(String[] args) {
        Colour redColor = new Colour(255, 0, 0, 255);
        Colour blueColor = new Colour(0, 255, 0, 255);

        Triangle triangle = new Triangle(blueColor, 3, 4, 5);
        Rectangle rectangle = new Rectangle(redColor, 5, 5);

        ShapeDescriber.describe(triangle);
        ShapeDescriber.describe(rectangle);
    }
}
