package edu.vv.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountEngineTest {

    // Basis paths Q1..Q5 for applyDiscount (CC=5 => 5 tests)
    private final DiscountEngine engine = new DiscountEngine();

    @Test
    void Q1_zeroOrNegativeTotal_returnsZero() {
        assertEquals(0.0, engine.applyDiscount(0.0, false, false, false));
    }

    @Test
    void Q2_blackFriday_hasPriority() {
        assertEquals(70.0, engine.applyDiscount(100.0, true, true, true)); // BF wins
    }

    @Test
    void Q3_couponAndStudent_20percent() {
        assertEquals(80.0, engine.applyDiscount(100.0, true, true, false));
    }

    @Test
    void Q4_couponOrStudent_10percent() {
        assertEquals(90.0, engine.applyDiscount(100.0, true, false, false));
        assertEquals(90.0, engine.applyDiscount(100.0, false, true, false));
    }

    @Test
    void Q5_noDiscount() {
        assertEquals(150.0, engine.applyDiscount(150.0, false, false, false));
    }
}
