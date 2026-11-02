import java.math.BigDecimal;

public class PricingDemo {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2 == 0.3);
        BigDecimal price = new BigDecimal("0.10");
        System.out.println(price.multiply(BigDecimal.valueOf(3)));
    }
}
