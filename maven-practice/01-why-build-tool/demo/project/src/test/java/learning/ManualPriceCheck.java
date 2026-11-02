package learning;

import java.math.BigDecimal;

// Standalone smoke check; not an automated Maven/JUnit test.
public class ManualPriceCheck {
    public static void main(String[] args) {
        BigDecimal result = Main.total(new BigDecimal("19.90"), 3);
        if (result.compareTo(new BigDecimal("59.70")) != 0) {
            throw new AssertionError("Unexpected total: " + result);
        }
        try {
            Main.total(BigDecimal.ONE, 0);
            throw new AssertionError("Zero quantity must be rejected");
        } catch (IllegalArgumentException expected) {
            System.out.println("Valid total and invalid quantity checks passed");
        }
    }
}
