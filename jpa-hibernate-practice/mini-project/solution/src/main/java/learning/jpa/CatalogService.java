package learning.jpa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogService {
    private final ProductRepository products;
    private final CategoryRepository categories;
    public CatalogService(ProductRepository products, CategoryRepository categories) {
        this.products = products; this.categories = categories;
    }
    @Transactional
    public long addCategory(String name) { return categories.save(new Category(name)).getId(); }

    @Transactional
    public ProductView add(String name, BigDecimal price, int stock, Long categoryId) {
        Product product = new Product(name, price, stock);
        if (categoryId != null) {
            Category category = categories.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("category not found"));
            category.addProduct(product);
        }
        return view(products.save(product));
    }
    @Transactional(readOnly = true)
    public List<ProductView> list(boolean fetchCategory) {
        List<Product> result = fetchCategory ? products.findAllWithCategory() : products.findAllByOrderByIdAsc();
        return result.stream().map(this::view).toList(); // lazy category read inside transaction
    }
    @Transactional(readOnly = true)
    public Optional<ProductView> find(long id) { return products.findById(id).map(this::view); }

    @Transactional
    public boolean update(long id, String name, BigDecimal price, int stock) {
        Optional<Product> found = products.findById(id);
        if (found.isEmpty()) return false;
        found.get().updateDetails(name, price, stock); // managed entity dirty checking
        return true;
    }
    @Transactional
    public boolean delete(long id) {
        Optional<Product> found = products.findById(id);
        if (found.isEmpty()) return false;
        products.delete(found.get());
        return true;
    }
    @Transactional
    public void failAdd() {
        products.save(new Product("ROLLBACK-DEMO", new BigDecimal("10.00"), 1));
        throw new IllegalStateException("Intentional rollback demo");
    }
    private ProductView view(Product p) {
        return new ProductView(p.getId(), p.getName(), p.getPrice(), p.getStock(),
            p.getCategory() == null ? null : p.getCategory().getName());
    }
}
