package learning.testing;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceMockTest {
    @Test
    void missingIdIsLookedUpThenReported() {
        ProductRepository repository = mock(ProductRepository.class);
        when(repository.findById(9L)).thenReturn(Optional.empty());
        ProductService service = new ProductService(repository);
        assertThrows(ProductNotFoundException.class, () -> service.get(9L));
        verify(repository).findById(9L);
    }
    @Test
    void invalidIdDoesNotCallRepository() {
        ProductRepository repository = mock(ProductRepository.class);
        ProductService service = new ProductService(repository);
        assertThrows(IllegalArgumentException.class, () -> service.get(0));
        verifyNoInteractions(repository);
    }
}
