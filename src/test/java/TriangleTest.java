import org.example.Colour;
import org.example.Triangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testGetArea() {
        Triangle triangle = new Triangle(new Colour(255, 0, 0), 3, 4, 5);
        assertEquals(6.0, triangle.getArea());
    }

    @Test
    void testGetPerimeter() {
        Triangle triangle = new Triangle(new Colour(255, 0, 0), 3, 4, 5);
        assertEquals(12.0, triangle.getPerimeter());
    }
}