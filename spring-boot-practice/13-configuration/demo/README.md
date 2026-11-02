# Demo — Cấu hình và môi trường

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
@Configuration
class ClockConfig {
    @Bean
    java.time.Clock clock() { return java.time.Clock.systemUTC(); }
}
```
Minh họa factory bean; chưa cần thêm vào product API nếu không sử dụng thời gian. Không có Spring: tạo Clock trong main rồi truyền qua constructor.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
