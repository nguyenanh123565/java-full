# Demo — DTO định hình dữ liệu qua biên HTTP

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
ProductResponse toResponse(Product product) {
    return new ProductResponse(product.id(), product.name(), product.price());
}
```
Mapping thủ công vài field giúp thấy ranh giới dữ liệu, chưa cần thư viện mapper.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
