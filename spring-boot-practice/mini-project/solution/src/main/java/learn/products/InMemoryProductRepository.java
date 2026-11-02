package learn.products;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    @Override
    public List<Product> findAll() {
        return products.values().stream().sorted(Comparator.comparingLong(Product::id)).toList();
    }

    @Override
    public Optional<Product> find(long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public Product create(String name, BigDecimal price) {
        long id = sequence.incrementAndGet();
        Product product = new Product(id, name, price);
        products.put(id, product);
        return product;
    }

    @Override
    public Optional<Product> update(long id, String name, BigDecimal price) {
        return Optional.ofNullable(products.computeIfPresent(id,
                (key, old) -> new Product(key, name, price)));
    }

    @Override
    public boolean delete(long id) {
        return products.remove(id) != null;
    }
}
