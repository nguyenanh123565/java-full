# Demo — Dependency Injection bằng constructor

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
var repository = new InMemoryProductRepository();
var service = new ProductService(repository);
var controller = new ProductController(service);
```
Đây là lắp ráp Java thuần tương đương ý tưởng DI; trong project thực, container quản lý vòng đời.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
