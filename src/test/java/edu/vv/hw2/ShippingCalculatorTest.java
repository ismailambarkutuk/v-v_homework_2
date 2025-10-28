package edu.vv.hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShippingCalculatorTest {

    // Basis paths P1..P5 for calculateShipping
    @Test
    void P1_shouldThrow_whenWeightNonPositive() {
        ShippingCalculator sc = new ShippingCalculator();
        assertThrows(IllegalArgumentException.class,
            () -> sc.calculateShipping(0.0, ShippingCalculator.Region.US, false));
    }

    @Test
    void P2_US_standard() {
        ShippingCalculator sc = new ShippingCalculator();
        double fee = sc.calculateShipping(1.2, ShippingCalculator.Region.US, false);
        assertEquals(7.0 + Math.ceil(1.2), fee);
    }

    @Test
    void P3_EU_express() {
        ShippingCalculator sc = new ShippingCalculator();
        double fee = sc.calculateShipping(2.0, ShippingCalculator.Region.EU, true);
        assertEquals(10.0 + 8.0 + Math.ceil(2.0), fee);
    }

    @Test
    void P4_OTHER_standard() {
        ShippingCalculator sc = new ShippingCalculator();
        double fee = sc.calculateShipping(3.4, ShippingCalculator.Region.OTHER, false);
        assertEquals(15.0 + Math.ceil(3.4), fee);
    }

    @Test
    void P5_US_express() {
        ShippingCalculator sc = new ShippingCalculator();
        double fee = sc.calculateShipping(0.6, ShippingCalculator.Region.US, true);
        assertEquals(7.0 + 8.0 + Math.ceil(0.6), fee);
    }
}
