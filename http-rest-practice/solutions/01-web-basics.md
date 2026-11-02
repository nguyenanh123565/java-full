# Đối chiếu 01 — Web basics

Chỉ mở sau khi đã làm ba TODO; đây là hướng giải thích mẫu.

## Bài 1

Điện thoại → HTTP request → backend → truy vấn PostgreSQL → backend tạo HTTP response → điện thoại đọc dữ liệu và hiển thị. Backend kiểm tra quyền và quy tắc nghiệp vụ. Nếu phát mật khẩu database cho client, người dùng có thể lấy thông tin đó để vượt qua các kiểm tra của backend; ứng dụng cũng phụ thuộc trực tiếp vào schema và kết nối database.

## Bài 2

- Server chưa chạy: thường bị từ chối kết nối hoặc timeout; chưa có response HTTP từ backend đó.
- Sai URL: nếu đã kết nối tới backend, backend có thể trả response thông báo không tìm thấy.
- Database mất kết nối: backend đã nhận request; có thể trả response lỗi dịch vụ nếu xử lý lỗi đúng.

SQL chỉ thuộc một bước xử lý. Nó không khởi động server, thay cổng hay sửa URL.

## Bài 3

`localhost` trên điện thoại là điện thoại. Cần xác định địa chỉ mạng của máy tính, việc hai thiết bị có thể liên lạc, server có lắng nghe trên địa chỉ mạng hay chỉ loopback, và firewall có cho phép kết nối hay không. Server lab chỉ cần dùng nội bộ trên máy học; bài này không yêu cầu đổi thiết lập. Thành công từ máy tính mới kiểm tra được đường kết nối cục bộ, chưa kiểm tra đường từ điện thoại.
