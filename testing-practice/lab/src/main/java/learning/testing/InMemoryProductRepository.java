package learning.testing;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> products = Map.of(1L, new Product(1L, "Book", 3));
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(products.get(id));
    }
}
