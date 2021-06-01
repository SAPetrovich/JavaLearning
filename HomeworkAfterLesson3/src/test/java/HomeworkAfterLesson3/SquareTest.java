package HomeworkAfterLesson3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    static Square square = new Square(3);

    @Test
    public void getName() {
        assertEquals ("Квадрат", square.getName());
    }

    @Test
    public void getPerimeter() {
        assertEquals (12.000, square.getPerimeter(), 0.0001 );
    }

    @Test
    public void getArea() {
        assertEquals (9.000, square.getArea(), 0.0001 );
    }
}