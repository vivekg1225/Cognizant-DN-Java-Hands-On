import org.example.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AAATest {
    Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
        System.out.println("Setup Completed");
    }

    @After
    public void tearDown(){
        calculator = null;
        System.out.println("Resources Released");
    }

    @Test
    public void testAdd(){
        int result = calculator.add(15, 25);

        assertEquals(40, result);
    }

    @Test
    public void testMultiply(){
        int result = calculator.multiply(6, 7);

        assertEquals(42, result);
    }
}
