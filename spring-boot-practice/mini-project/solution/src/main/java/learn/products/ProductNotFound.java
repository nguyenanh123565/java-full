package learn.products;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(long id) {
        super("Product " + id + " not found");
    }
}
