package Lesson1;

import org.junit.Before;
import org.junit.Test;

import static Lesson1.SetOfTags.*;
import static org.junit.Assert.*;

public class SetOfTagsTest {

    static SetOfTags tags;

    @Before
    public void setUp() {
        tags = new SetOfTags();
    }

    @Test
    public void testToString() {

        assertEquals("", tags.toString());

        tags.add("Вася");
        assertEquals("Вася", tags.toString());

        tags.add("Дуся");
        assertEquals("Вася" + TAGS_DELIMITER + "Дуся", tags.toString());
    }

    @Test
    public void isEmpty() {
        assertTrue("Нет элементов", tags.isEmpty());

        tags.add("Вася");
        assertFalse("Один элемент", tags.isEmpty());

        tags.add("Петя");
        assertFalse("Два элемента", tags.isEmpty());

        tags.clear();
        assertTrue("После очистки", tags.isEmpty());
    }

    @Test
    public void size() {
        assertEquals("Нет элементов", 0, tags.size());

        tags.add("Вася");
        assertEquals("Один элемент",1, tags.size());

        tags.add("Петя");
        assertEquals("Два элемента", 2, tags.size());

        tags.clear();
        assertEquals("После очистки", 0, tags.size());
    }

    @Test
    public void clear() {
        tags.add("Вася, Петя");

        assertNotEquals(0, tags.size());
        tags.clear();
        assertEquals(0, tags.size());
    }

    @Test
    public void add() {

        assertTrue( tags.add("Вася") );
        assertEquals(1, tags.size());

        assertTrue( tags.add("Петя") );
        assertEquals(2, tags.size());

        assertFalse( tags.add("Вася") );
        assertEquals(2, tags.size());

        assertTrue( tags.add("Вася,Петя, Маша Саша") );
        assertEquals(4, tags.size());

        assertFalse( tags.add("") );
        assertEquals(4, tags.size());

        assertFalse( tags.add(" ") );
        assertEquals(4, tags.size());
    }

    @Test
    public void contains() {
        tags.add("Вася,Петя, Маша Саша");

        assertTrue( tags.contains("Вася") );
        assertTrue( tags.contains("Саша Петя") );
        assertFalse( tags.contains("Юра") );
        assertFalse( tags.contains("Юра, Саша") );
    }

    @Test
    public void remove() {
        tags.add("Вася,Петя, Маша Саша");

        assertTrue( tags.remove("Вася Саша") );
        assertEquals(2, tags.size());

        assertFalse( tags.remove("Игорь") );
        assertEquals(2, tags.size());
    }

    @Test
    public void union() {
        tags.add("Вася,Петя, Маша Саша");

        assertTrue( tags.union("Маша Глаша") );
        assertEquals(5, tags.size());

        assertFalse( tags.union("Вася,Глаша") );
        assertEquals(5, tags.size());
    }

    @Test
    public void difference() {
        tags.add("Вася,Петя, Маша Саша");

        assertTrue( tags.difference("Маша Глаша") );
        assertEquals(3, tags.size());

        assertTrue( tags.difference("Вася,Петя, Маша Саша Шура Агафья") );
        assertEquals(0, tags.size());
    }

    @Test
    public void intersection() {
        tags.add("Вася,Петя, Маша Саша");

        assertTrue( tags.intersection("Маша Глаша") );
        assertEquals(1, tags.size());
        assertEquals("Маша", tags.toString());
    }
}