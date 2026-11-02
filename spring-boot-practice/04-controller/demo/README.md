# Demo — Controller nhận và trả dữ liệu HTTP

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

Với HelloController trên, `GET /hello` được MVC chọn theo method+path. Giá trị Map được message converter ghi thành JSON; không cần tự nối chuỗi JSON. `GET /unknown` không gọi hello.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
