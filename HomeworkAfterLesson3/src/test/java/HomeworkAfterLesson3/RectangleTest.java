package HomeworkAfterLesson3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    static Rectangle rectangle = new Rectangle(2, 3);

    @Test
    public void getName() {
        assertEquals ("Прямоугольник", rectangle.getName());
    }

    @Test
    public void getPerimeter() {
        assertEquals (10.000, rectangle.getPerimeter(), 0.0001 );
    }

    @Test
    public void getArea() {
        assertEquals (6.000, rectangle.getArea(), 0.0001 );
    }
}