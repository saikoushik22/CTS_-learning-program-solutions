package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void testAddition() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }
}
