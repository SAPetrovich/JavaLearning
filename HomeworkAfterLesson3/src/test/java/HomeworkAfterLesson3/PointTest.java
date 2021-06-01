package HomeworkAfterLesson3;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    static Point point = new Point();

    @Test
    public void getName() {
        assertEquals ("Точка", point.getName());
    }

    @Test
    public void getPerimeter() {
        assertEquals (0.000, point.getPerimeter(), 0.0001 );
    }

    @Test
    public void getArea() {
        assertEquals (0.000, point.getArea(), 0.0001 );
    }
}