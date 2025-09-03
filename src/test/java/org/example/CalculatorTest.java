package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void additionTest() {
        assertEquals(2, calculator.add(1,1));
    }

    @Test
    public void subtractionTest() {
        assertEquals(2, calculator.sub(4, 2));
    }

    @Test
    public void multiplicationTest() {
        assertEquals(4, calculator.mul(2, 2));
    }

    @Test
    public void divisionTest() {
        assertEquals(2, calculator.div(4, 2));
    }
}
