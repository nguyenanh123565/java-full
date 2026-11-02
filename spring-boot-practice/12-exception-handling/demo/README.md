# Demo — Dịch exception thành HTTP response

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
@RestControllerAdvice
class ApiErrors {
    @ExceptionHandler(ProductNotFound.class)
    ResponseEntity<Map<String, String>> missing(ProductNotFound ex) {
        return ResponseEntity.status(404).body(Map.of("error", ex.getMessage()));
    }
}
```

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
