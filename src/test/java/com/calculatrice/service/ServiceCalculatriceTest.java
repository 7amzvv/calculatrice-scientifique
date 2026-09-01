package com.calculatrice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceCalculatriceTest {

    @Autowired
    private ServiceCalculatrice serviceCalculatrice;

    @Test
    public void testAddition() throws Exception {
        assertEquals(7.0, serviceCalculatrice.calculer("2+5"));
    }

    @Test
    public void testSoustraction() throws Exception {
        assertEquals(7.0, serviceCalculatrice.calculer("10-3"));
    }

    @Test
    public void testMultiplication() throws Exception {
        assertEquals(20.0, serviceCalculatrice.calculer("5*4"));
    }

    @Test
    public void testDivision() throws Exception {
        assertEquals(4.0, serviceCalculatrice.calculer("20/5"));
    }

    @Test
    public void testPuissance() throws Exception {
        assertEquals(4.0, serviceCalculatrice.calculer("2^2"));
    }

    @Test
    public void testRacineCarre() throws Exception {
        assertEquals(4.0, serviceCalculatrice.calculer("sqrt(16)"));
    }

    @Test
    public void testParentheses() throws Exception {
        assertEquals(14.0, serviceCalculatrice.calculer("(2+5)*2"));
    }

    @Test
    public void testPrioriteOperateurs() throws Exception {
        assertEquals(17.0, serviceCalculatrice.calculer("2+5*3"));
    }

    @Test
    public void testDivisionParZero() {
        assertThrows(ArithmeticException.class, () -> {
            serviceCalculatrice.calculer("10/0");
        });
    }

    @Test
    public void testRacineNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            serviceCalculatrice.calculer("sqrt(-4)");
        });
    }

    @Test
    public void testExpressionVide() {
        assertThrows(IllegalArgumentException.class, () -> {
            serviceCalculatrice.calculer("");
        });
    }

    @Test
    public void testSin() throws Exception {
        double result = serviceCalculatrice.calculer("sin(0)");
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCos() throws Exception {
        double result = serviceCalculatrice.calculer("cos(0)");
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testLog() throws Exception {
        double result = serviceCalculatrice.calculer("log(100)");
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testLn() throws Exception {
        double result = serviceCalculatrice.calculer("ln(2.718281828)");
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testNombresDecimaux() throws Exception {
        assertEquals(3.5, serviceCalculatrice.calculer("1.5+2.0"));
    }
}