package learning.testing;
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long id) {
        super("Product not found: " + id);
    }
}
