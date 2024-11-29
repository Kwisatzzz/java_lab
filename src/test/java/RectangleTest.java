import org.example.Colour;
import org.example.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void testGetArea() {
        Rectangle rectangle = new Rectangle(new Colour(0, 255, 0), 5, 5);
        assertEquals(25.0, rectangle.getArea());
    }

    @Test
    void testGetPerimeter() {
        Rectangle rectangle = new Rectangle(new Colour(0, 255, 0), 5, 5);
        assertEquals(20.0, rectangle.getPerimeter());
    }
}