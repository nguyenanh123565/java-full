package learning.testing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") long id) { return service.get(id); }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Void> missing() { return ResponseEntity.notFound().build(); }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> invalid() { return ResponseEntity.badRequest().build(); }
}
