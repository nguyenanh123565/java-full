# Demo — Authentication: bạn là ai?

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

So sánh `GET /me?username=admin` với GET /me sau đăng nhập. Query là dữ liệu client tùy sửa; principal của request trong reference đến từ session đã được security framework xác thực.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
