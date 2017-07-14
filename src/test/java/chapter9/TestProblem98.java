package chapter9;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblem98 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNegative() {
        Problem98.calculateCoinPayments(-99);
    }

    @Test
    public void testOneCent() {
        Set<String> coinPayments = Problem98.calculateCoinPayments(1);
        assertEquals(1, coinPayments.size());
        assertTrue(coinPayments.contains("1p"));
    }

    @Test
    public void testFiveCents() {
        Set<String> coinPayments = Problem98.calculateCoinPayments(5);
        assertEquals(2, coinPayments.size());
        assertTrue(coinPayments.contains("5p"));
        assertTrue(coinPayments.contains("1n"));
    }

    @Test
    public void testTenCents() {
        Set<String> coinPayments = Problem98.calculateCoinPayments(10);
        assertEquals(4, coinPayments.size());
        assertTrue(coinPayments.contains("10p"));
        assertTrue(coinPayments.contains("1n+5p"));
        assertTrue(coinPayments.contains("2n"));
        assertTrue(coinPayments.contains("1d"));
    }

    @Test
    public void testFifteenCents() {
        Set<String> coinPayments = Problem98.calculateCoinPayments(15);
        assertEquals(6, coinPayments.size());
        assertTrue(coinPayments.contains("15p"));
        assertTrue(coinPayments.contains("1n+10p"));
        assertTrue(coinPayments.contains("2n+5p"));
        assertTrue(coinPayments.contains("3n"));
        assertTrue(coinPayments.contains("1d+5p"));
        assertTrue(coinPayments.contains("1d+1n"));
    }
}