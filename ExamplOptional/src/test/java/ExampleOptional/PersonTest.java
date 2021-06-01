package ExampleOptional;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonTest {

    Person p;

    @Before
    public void setUp() {
        p = new Person();
    }

    @Test
    public void getFullName() {
        assertEquals("", p.getFName());

        p.setFName("Иван");
        assertEquals("Иван", p.getFName());
        assertEquals("Иван", p.getFullName());

        p.setMName(Optional.of("Петрович"));
        assertEquals("Иван", p.getFName());
        assertEquals("Иван Петрович", p.getFullName());
    }

    @Test
    public void hasContacts() {
        assertFalse(p.hasContacts());

        p.setPhone(Optional.of("1234567890"));
        assertTrue(p.hasContacts());

        p.setEmail(Optional.of("1@2"));
        assertTrue(p.hasContacts());

        p.setPhone(Optional.empty());
        assertTrue(p.hasContacts());

        p.setEmail(Optional.empty());
        assertFalse(p.hasContacts());
    }
}