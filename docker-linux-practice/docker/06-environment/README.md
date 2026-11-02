# Environment trong Compose: cấu hình kết nối

## 1. Problem — tại sao khái niệm tồn tại

App cần DB URL/username/password phù hợp môi trường; DB image cũng cần biết user/database lúc initialize.

## 2. Mental model

Compose environment truyền key/value vào process container. App đọc datasource properties; PostgreSQL image đọc POSTGRES_* để khởi tạo data directory mới. Đổi POSTGRES_PASSWORD khi volume đã có dữ liệu không tự đổi password role trong DB.

## 3. Ví dụ nhỏ

App dùng SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/learning_backend; DB initialize learner/learning_backend với mật khẩu giả của demo.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: System.getenv và Spring property binding chuyển cấu hình thành datasource. HTTP: request header không thay cấu hình DB của process. SQL: password role nằm trong DB đã initialize, không phải biến env tự đồng bộ mãi.

## 5. Những lỗi thường gặp

Đổi env mà không recreate app; đổi POSTGRES_PASSWORD nhưng giữ volume cũ rồi nghĩ role đổi; đưa secret thật vào Git; nhầm env với SQL parameters.

## 6. Câu hỏi tự kiểm tra

Ai đọc POSTGRES_DB? Ai đọc SPRING_DATASOURCE_URL? Volume cũ ảnh hưởng initialize thế nào?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
