package learn.security;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class LearningController {
    // Mục tiêu bài là security: list tên nhỏ, không thay Product API đầy đủ.
    private final List<String> products = new CopyOnWriteArrayList<>(List.of("Notebook"));

    @GetMapping("/products")
    public List<String> products() {
        return List.copyOf(products);
    }

    @PostMapping("/products")
    public Map<String, String> create(@RequestBody NewProduct request) {
        if (request.name() == null || request.name().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name is required");
        }
        products.add(request.name().strip());
        return Map.of("added", request.name().strip());
    }

    @GetMapping("/me")
    public Map<String, String> me(Principal principal) {
        return Map.of("username", principal.getName());
    }

    @GetMapping("/csrf")
    public Map<String, String> csrf(CsrfToken token) {
        return Map.of("headerName", token.getHeaderName(), "parameterName", token.getParameterName(),
                "token", token.getToken());
    }

    public record NewProduct(String name) {}
}
