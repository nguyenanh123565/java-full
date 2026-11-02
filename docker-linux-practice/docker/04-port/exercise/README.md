# Bài tập — Port mapping: host 8081 → container 8080

- TODO: Vẽ địa chỉ từ ba góc nhìn host/app/db; trên bản copy đổi host port thành 8082, giữ port nội bộ.
- TODO: **Dự đoán trước khi chạy:** Đổi 8081→8082 có cần đổi server.port không? curl cũ còn đúng không?
- TODO: **Vì sao:** Vì sao không cần publish 5432 cho app trong cùng mạng Compose kết nối DB?
- TODO: **Liên hệ kiến thức cũ:** Viết một URL HTTP dùng trên host và một JDBC URL dùng trong app container, giải thích từng phần.
- TODO: ghi command, điều quan sát được và kết luận. Chỉ sửa bản copy/thư mục thử riêng; dùng dữ liệu giả.
