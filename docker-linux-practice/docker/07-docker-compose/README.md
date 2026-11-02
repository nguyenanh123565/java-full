# Compose: mô tả app và DB cùng nhau

## 1. Problem — tại sao khái niệm tồn tại

Chạy tay nhiều container cần lặp tên network, env, port và volume. Cần một file mô tả quan hệ để nhìn được toàn bộ demo.

## 2. Mental model

Compose định nghĩa services, networks và volumes. Service name db là DNS nội bộ. depends_on với service_healthy đợi healthcheck trước khi tạo app, nhưng không thay retry/resilience hoặc bảo đảm DB luôn khỏe về sau.

## 3. Ví dụ nhỏ

Compose demo có app build từ Dockerfile, db dùng postgres 17, healthcheck pg_isready, named volume pg_data và chỉ publish app 8081.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: controller dùng JdbcTemplate rồi driver gửi SQL. HTTP: host curl đi 8081→app 8080. SQL: pg_isready báo server sẵn nhận kết nối, chưa chứng minh schema/logic query đúng.

## 5. Những lỗi thường gặp

Tưởng depends_on cơ bản đợi DB ready; dùng sai DNS localhost; nghĩ Compose là cloud/orchestrator production; chạy down -v như thao tác dọn thường ngày.

## 6. Câu hỏi tự kiểm tra

pg_isready chứng minh schema đúng không? depends_on có tự sửa app khi DB mất giữa chừng không? Vì sao service app/db dùng cùng network mặc định?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
