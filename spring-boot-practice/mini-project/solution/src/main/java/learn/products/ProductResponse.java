package learn.products;

import java.math.BigDecimal;

public record ProductResponse(long id, String name, BigDecimal price) {}
