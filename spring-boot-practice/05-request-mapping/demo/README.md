# Demo — Ánh xạ method và URI

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
@RequestMapping("/products") // trên class @RestController
// trong class:
@GetMapping("/{id}")
ProductResponse find(@PathVariable("id") long id) { return service.find(id); }
```
`@PathVariable` lấy giá trị từ path template; Java thủ công phải tách đoạn URI và parse long. HTTP liên hệ: đây là path, không phải query/body.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
