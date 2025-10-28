    package edu.vv.hw2;

    /**
     * Basis-path candidate #2 (CC = 5).
     * Decisions:
     *  1) total <= 0 ? -> 0
     *  2) isBlackFriday ?
     *  3) hasCoupon && isStudent ?
     *  4) hasCoupon || isStudent ?
     */
    public class DiscountEngine {

        public double applyDiscount(double total,
                                    boolean hasCoupon,
                                    boolean isStudent,
                                    boolean isBlackFriday) {

            if (total <= 0) {                        // D1
                return 0.0;
            }

            if (isBlackFriday) {                     // D2
                return total * 0.70; // 30% off
            } else if (hasCoupon && isStudent) {     // D3
                return total * 0.80; // 20% off
            } else if (hasCoupon || isStudent) {     // D4
                return total * 0.90; // 10% off
            } else {
                return total; // no discount
            }
        }
    }
