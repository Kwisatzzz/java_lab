package org.example;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ShapeDAO shapeDAO = new ShapeDAO();

        Colour red = new Colour(255, 0, 0, 255);
        Rectangle rectangle = new Rectangle(red, 10, 20);

        Colour blue = new Colour(0, 0, 255, 255);
        Triangle triangle = new Triangle(blue, 3, 4, 5);

        shapeDAO.save(rectangle);
        shapeDAO.save(triangle);

        List<Rectangle> rectangles = shapeDAO.findAll(Rectangle.class);
        rectangles.forEach(shape -> {
            System.out.println("Rectangle: " + shape.getClass().getSimpleName());
            System.out.println("Area: " + shape.getArea());
        });

        List<Triangle> triangles = shapeDAO.findAll(Triangle.class);
        triangles.forEach(shape -> {
            System.out.println("Triangle: " + shape.getClass().getSimpleName());
            System.out.println("Area: " + shape.getArea());
        });

        Rectangle foundRectangle = shapeDAO.findById(Rectangle.class, rectangle.getId());
        System.out.println("Found shape: " + foundRectangle.getClass().getSimpleName());

        shapeDAO.deleteById(Triangle.class, triangle.getId());
        System.out.println("Deleted triangle with ID: " + triangle.getId());

        shapeDAO.close();
    }
}
