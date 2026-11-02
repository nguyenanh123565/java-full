# Demo — Status, header và response body

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
@PostMapping
ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
    ProductResponse result = service.create(request);
    return ResponseEntity.created(URI.create("/products/" + result.id())).body(result);
}
```
`@Valid` kích hoạt kiểm tra constraint trên request; xem lesson 11.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
