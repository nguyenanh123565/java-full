package learn.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> find(long id);
    Product create(String name, BigDecimal price);
    Optional<Product> update(long id, String name, BigDecimal price);
    boolean delete(long id);
}
