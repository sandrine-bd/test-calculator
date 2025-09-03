package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(2, calculator.add(1,1));
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
    public void testDivision() {
        assertEquals(2, calculator.div(4, 2));
    }
}
