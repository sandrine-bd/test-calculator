package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(2, calculator.add(1,1));
    }

    @Test
    public void testAdditionMaxValue() {
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE,1));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.sub(4, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(4, calculator.mul(2, 2));
    }

    @Test
    public void testMultiplicationMaxValue() {
        assertEquals(Integer.MAX_VALUE, calculator.mul(Integer.MAX_VALUE,2));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.div(4, 2));
    }

    @Test
    public void testDivisionParZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.div(4, 0);
        });
    }

    @Test
    public void testDivisionFloat() {
        assertEquals(3.333, calculator.div(10, 3), 0.001);
    }
}
