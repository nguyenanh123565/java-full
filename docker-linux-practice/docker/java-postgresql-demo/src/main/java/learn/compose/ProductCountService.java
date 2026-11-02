package learn.compose;

import org.springframework.stereotype.Service;

@Service
public class ProductCountService {
    private final ProductCountRepository repository;

    public ProductCountService(ProductCountRepository repository) {
        this.repository = repository;
    }

    public long countProducts() {
        return repository.count();
    }
}
