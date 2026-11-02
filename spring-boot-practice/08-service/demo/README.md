# Demo — Service giữ quy tắc nghiệp vụ

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
ProductResponse update(long id, ProductRequest request) {
    Product updated = repository.update(id, request.name().strip(), request.price())
            .orElseThrow(() -> new ProductNotFound(id));
    return toResponse(updated);
}
```
Trong reference, repository hỗ trợ update có kiểm tra tồn tại để tránh cập nhật missing id.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
