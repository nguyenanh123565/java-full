# Demo — Path, query và JSON body

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
@GetMapping
List<ProductResponse> list(@RequestParam(name="name", required=false) String name) {
    return service.list(name);
}
```
Snippet mở rộng: mini-project ban đầu chỉ list tất cả. Người học tự thêm bộ lọc.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
