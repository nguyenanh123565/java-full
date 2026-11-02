# Container: process với môi trường tách biệt

## 1. Problem — tại sao khái niệm tồn tại

App chạy trên máy bạn nhưng thiếu runtime/cấu hình ở máy khác. Cần mô tả môi trường chạy và giới hạn file/network rõ hơn.

## 2. Mental model

Image là mẫu; container là instance có process, filesystem view và network riêng. Container chia sẻ kernel môi trường Linux, không phải mỗi container là VM đầy đủ. Trên Windows Docker Desktop thường chạy Linux VM/WSL 2 bên dưới.

## 3. Ví dụ nhỏ

Cùng image Java có thể tạo hai container với env và port host khác nhau. Dừng container dừng process; source trên host không tự sửa image đã build.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: JVM vẫn chạy bytecode trong container. HTTP: request qua port mapping tới server process. SQL: PostgreSQL container là process DB riêng, app container chỉ là client.

## 5. Những lỗi thường gặp

Tưởng container là file JAR; nghĩ Docker thay JVM; sửa source rồi chỉ restart container cũ; gộp DB và app vì tưởng container là nguyên project.

## 6. Câu hỏi tự kiểm tra

Image khác container ở đâu? Container đang stopped có process Java đang chạy không? VM/host kernel tham gia thế nào?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
