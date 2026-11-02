package learning.jpa;
import java.math.BigDecimal;
public record ProductView(Long id, String name, BigDecimal price, int stock, String categoryName) { }
