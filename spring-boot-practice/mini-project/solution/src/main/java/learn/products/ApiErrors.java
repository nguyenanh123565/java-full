package learn.products;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrors {
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Map<String, String>> missing(ProductNotFound error) {
        return ResponseEntity.status(404).body(Map.of("error", error.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> invalid(MethodArgumentNotValidException error) {
        Map<String, String> details = new LinkedHashMap<>();
        error.getBindingResult().getFieldErrors().forEach(field ->
                details.putIfAbsent(field.getField(), field.getDefaultMessage() == null
                        ? "invalid" : field.getDefaultMessage()));
        return ResponseEntity.badRequest().body(details);
    }
}
