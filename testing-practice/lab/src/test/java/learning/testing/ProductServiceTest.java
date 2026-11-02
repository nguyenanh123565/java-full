package learning.testing;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    @Test
    void returnsProductFromRepository() {
        // Arrange: stub viết tay, chưa dùng Mockito hay Spring context.
        ProductRepository repository = id -> Optional.of(new Product(id, "Book", 3));
        ProductService service = new ProductService(repository);
        // Act
        Product actual = service.get(1);
        // Assert
        assertEquals("Book", actual.name());
        assertEquals(3, actual.stock());
    }
    @Test
    void missingProductHasExplicitError() {
        ProductService service = new ProductService(id -> Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> service.get(9));
    }
}
