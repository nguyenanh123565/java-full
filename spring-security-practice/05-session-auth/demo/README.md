# Demo — Session authentication trước JWT

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

Mở trình duyệt `/login`, đăng nhập bằng tài khoản demo đã đặt qua environment, mở `/me`. Với PowerShell dùng WebRequestSession giữ cookie và `/csrf` lấy token; quy trình đầy đủ trong mini-project/solution/README.md.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
