package learning;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class Main {
    public static BigDecimal total(BigDecimal price, int quantity) {
        if (price == null || price.signum() < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Price must be non-negative; quantity must be positive");
        }
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getResourceAsStream("/app.properties")) {
            if (input == null) {
                throw new IllegalStateException("Missing app.properties on the classpath");
            }
            properties.load(input);
        }
        BigDecimal result = total(new BigDecimal("19.90"), 3);
        System.out.println(properties.getProperty("label") + ": " + result.toPlainString());
    }
}
