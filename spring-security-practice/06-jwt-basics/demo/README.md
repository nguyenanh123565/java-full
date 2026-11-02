# Demo — JWT: cấu trúc đọc được chưa phải đáng tin

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```json
{"sub":"user-42","iss":"https://issuer.example","aud":["learning-api"],"exp":1900000000}
```
Đây chỉ là dữ liệu minh họa, không phải token hợp lệ và không dùng để đăng nhập reference session.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
