# Demo — Authorization: bạn được làm gì?

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
http.authorizeHttpRequests(auth -> auth
    .requestMatchers(HttpMethod.GET, "/products").permitAll()
    .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
    .anyRequest().authenticated());
```
Đoạn cấu hình nằm trong SecurityFilterChain, không phải controller; mã đầy đủ ở mini-project/solution.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
