import java.math.BigDecimal;

public record JdbcProduct(long id, String name, BigDecimal price, int stock) { }
