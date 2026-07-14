import org.example.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalTest {

    Calculator c = new Calculator();

    @Test
    public void testAddition(){
        int result = c.add(5, 5);
        assertEquals(10, result);
    }

    @Test
    public void testSubtration(){
        int result = c.subtract(10, 2);
        assertEquals(8, result);
    }

    @Test
    public void testMultiply(){
        int result = c.multiply(10, 2);
        assertEquals(20, result);
    }

    @Test
    public void testDivision(){
        double result = c.division(5, 2);
        assertEquals(2.5, result, 0.001);
    }
}
