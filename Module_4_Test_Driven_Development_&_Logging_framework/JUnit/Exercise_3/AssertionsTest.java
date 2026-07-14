import org.example.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {
    Calculator c1 = new Calculator();

    @Test
    public void testAssertions(){
        assertEquals(15, c1.add(10, 5));

        assertTrue(c1.isPrime(5));

        assertFalse(c1.isPrime(10));

        String name = null;
        assertNull(name);

        Calculator obj = new Calculator();
        assertNotNull(obj);
    }
}
