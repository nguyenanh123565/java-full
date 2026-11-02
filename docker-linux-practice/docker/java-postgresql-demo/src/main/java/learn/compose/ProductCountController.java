package learn.compose;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCountController {
    private final ProductCountService service;

    public ProductCountController(ProductCountService service) {
        this.service = service;
    }

    @GetMapping("/products/count")
    public CountResponse count() {
        return new CountResponse(service.countProducts());
    }

    public record CountResponse(long count) {}
}
