import org.example.Colour;
import org.example.Rectangle;
import org.example.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testGetColor() {
        Colour color = new Colour(255, 0, 0, 128);
        Shape shape = new Rectangle(color, 5, 10);

        assertEquals(color, shape.getColor());
    }

    @Test
    void testGetColorDescription() {
        Colour color = new Colour(255, 255, 0, 255);
        Shape shape = new Rectangle(color, 5, 10);

        String expectedDescription = "Red: 255, Green: 255, Blue: 0, Alpha: 255";
        assertEquals(expectedDescription, shape.getColorDescription());
    }

    @Test
    void testPrint() {
        Colour color = new Colour(0, 0, 255);
        Shape shape = new Rectangle(color, 5, 10);

        assertDoesNotThrow(shape::print);
    }
}
