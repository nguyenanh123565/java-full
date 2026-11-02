package learning.testing;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public Product get(long id) {
        if (id <= 0) throw new IllegalArgumentException("id must be positive");
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
