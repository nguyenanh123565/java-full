# Demo — Role và permission có chủ đích

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
.roles("USER", "ADMIN")
// hoặc .authorities("product:read", "product:write")
```
Hai lựa chọn biểu diễn khác nhau. Nếu dùng hasRole thì phải có ROLE_ authority tương ứng; không thay tùy tiện.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
