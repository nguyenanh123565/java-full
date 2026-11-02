package learn.products;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public ProductResponse find(long id) {
        return toResponse(repository.find(id).orElseThrow(() -> new ProductNotFound(id)));
    }

    public ProductResponse create(ProductRequest request) {
        return toResponse(repository.create(request.name().strip(), request.price()));
    }

    public ProductResponse update(long id, ProductRequest request) {
        return toResponse(repository.update(id, request.name().strip(), request.price())
                .orElseThrow(() -> new ProductNotFound(id)));
    }

    public void delete(long id) {
        if (!repository.delete(id)) {
            throw new ProductNotFound(id);
        }
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(product.id(), product.name(), product.price());
    }
}
