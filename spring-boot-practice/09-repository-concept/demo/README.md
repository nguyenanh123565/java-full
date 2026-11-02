# Demo — Repository là ranh giới lưu trữ

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
private final Map<Long, Product> products = new ConcurrentHashMap<>();
private final AtomicLong sequence = new AtomicLong();
// Tạo id trong cùng process; không thay database sequence phân tán.
```
Reference sắp xếp danh sách theo id vì thứ tự lặp Map không là hợp đồng API.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
