import org.example.*;
import org.junit.jupiter.api.*;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeDAOTest {

    private static EntityManagerFactory emf;
    private ShapeDAO shapeDAO;

    @BeforeAll
    static void setup() {
        emf = Persistence.createEntityManagerFactory("shapesPU");
    }

    @BeforeEach
    void init() {
        shapeDAO = new ShapeDAO();
    }

    @AfterEach
    void tearDown() {
        shapeDAO.close();
    }

    @AfterAll
    static void cleanup() {
        emf.close();
    }

    @Test
    void testSaveAndFindRectangle() {
        Colour red = new Colour(255, 0, 0, 255);
        Rectangle rectangle = new Rectangle(red, 10, 20);
        shapeDAO.save(rectangle);
        Rectangle found = shapeDAO.findById(Rectangle.class, rectangle.getId());
        assertNotNull(found);
        assertEquals(10 * 20, found.getArea());
    }

    @Test
    void testFindAllRectangles() {
        Colour green = new Colour(0, 255, 0, 255);
        Rectangle rect1 = new Rectangle(green, 5, 10);
        Rectangle rect2 = new Rectangle(green, 2, 4);
        shapeDAO.save(rect1);
        shapeDAO.save(rect2);
        List<Rectangle> rectangles = shapeDAO.findAll(Rectangle.class);
        assertTrue(rectangles.size() >= 2);
    }

    @Test
    void testUpdateRectangle() {
        Colour blue = new Colour(0, 0, 255, 255);
        Rectangle rectangle = new Rectangle(blue, 15, 25);
        shapeDAO.save(rectangle);
        Rectangle toUpdate = shapeDAO.findById(Rectangle.class, rectangle.getId());
        assertNotNull(toUpdate);
        toUpdate.setX(20);
        toUpdate.setY(30);
        shapeDAO.save(toUpdate);
        Rectangle updated = shapeDAO.findById(Rectangle.class, rectangle.getId());
        assertNotNull(updated);
        assertEquals(20 * 30, updated.getArea(), 0.01);
    }


    @Test
    void testDeleteRectangle() {
        Colour yellow = new Colour(255, 255, 0, 255);
        Rectangle rectangle = new Rectangle(yellow, 7, 14);
        shapeDAO.save(rectangle);
        shapeDAO.deleteById(Rectangle.class, rectangle.getId());
        Rectangle deleted = shapeDAO.findById(Rectangle.class, rectangle.getId());
        assertNull(deleted);
    }
}
