package edu.vv.hw2;

/**
 * Basis-path candidate #1 (CC = 5).
 * Decisions:
 *  1) weight <= 0 ? -> IllegalArgumentException
 *  2) region == "US"
 *  3) region == "EU" (else -> OTHER)
 *  4) isExpress ?
 */
public class ShippingCalculator {

    public enum Region { US, EU, OTHER }

    /**
     * Returns shipping fee in monetary units.
     */
    public double calculateShipping(double weightKg, Region region, boolean isExpress) {
        if (weightKg <= 0) {                           // D1
            throw new IllegalArgumentException("weight must be > 0");
        }

        double base;
        if (region == Region.US) {                     // D2
            base = 7.0;
        } else if (region == Region.EU) {              // D3
            base = 10.0;
        } else {
            base = 15.0;
        }

        if (isExpress) {                               // D4
            base += 8.0;
        }

        // simple weight scaling (no new decisions)
        return base + Math.ceil(weightKg); // discrete kg steps
    }
}
