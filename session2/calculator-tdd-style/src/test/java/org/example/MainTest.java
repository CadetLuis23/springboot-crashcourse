package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Calculator calculator;

    @BeforeEach
    void createCalculator(){
        this.calculator = new Calculator();
    }

    @Test
    void createNewCalculator(){
        assertNotNull(calculator);
    }

    @Test
    void testCalculatorTurnOn(){
        calculator.turnOn();
        assertTrue(calculator.isOn());
    }

    @Test
    void testCalculatorTurnOff(){
        calculator.turnOn();
        assertTrue(calculator.isOn());
        calculator.turnOff();
        assertFalse(calculator.isOn());
    }
    @Test
    void testCalculatorIsOff(){
        calculator.turnOn();
        assertTrue(calculator.isOn());
        calculator.turnOff();
        assertTrue(calculator.isOff());
    }

    @Test
    void addingPositiveNumbers() {
        int expected = 10;
        int result = calculator.add(6, 4);
        assertEquals(expected, result);
    }

    @Test
    void addingNegativeNumbers() {
        int expected = -10;
        int result = calculator.add(-6, -4);
        assertEquals(expected, result);
    }

    @Test
    void addingOppositeSignedNumbers() {
        int expected = -2;
        int result = calculator.add(-6, 4);
        assertEquals(expected, result);
    }

    @Test
    void addingFloatingPointNumbers() {
        float expected = 10.5f;
        float result = calculator.add(7.5f, 3.0f);
        assertEquals(expected, result, 0.001);
    }

    @Test
    void subtractingPositiveNumbers(){
        int expected = 7;
        int result = calculator.subtract(12, 5);
        assertEquals(expected, result);
    }

    @Test
    void subtractingNegativeNumbers() {
        int expected = 20;
        int result = calculator.subtract(15, -5);
        assertEquals(expected, result);
    }

    @Test
    void subtractingFloatingPointNumbers() {
        float expected = 2.5f;
        float result = calculator.subtract(5.0f, 2.5f);
        assertEquals(expected, result);
    }

    @Test
    void multiplyingPositiveNumbers() {
        int expected = 50;
        int result = calculator.multiply(10, 5);
        assertEquals(expected, result);
    }

    @Test
    void multiplyingNegativeNumbers() {
        int expected = -20;
        int result = calculator.multiply(-2, 10);
        assertEquals(expected, result);
    }

    @Test
    void multiplyingFloatNumbers() {
        float expected = 13.75f;
        float result = calculator.multiply(5.5f, 2.5f);
        assertEquals(expected, result);
    }

    @Test
    void divisionOfTwoPositiveNumbers() {
        int expected = 5;
        int result = calculator.divide(10, 2);
        assertEquals(expected, result);
    }

    @Test
    void divisionByZero(){
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
    @Test
    void divisionOfTwoFloatingNumbers() {
        float expected = 3.0f;
        float result = calculator.divide(7.5f, 2.5f);
        assertEquals(expected, result);
    }
}