# Image: các lớp filesystem và cấu hình khởi chạy

## 1. Problem — tại sao khái niệm tồn tại

Cần phân phối đúng Java runtime và artifact thay vì yêu cầu mỗi máy chuẩn bị thủ công từng file.

## 2. Mental model

Image chứa layer filesystem read-only và metadata khởi chạy; container thêm writable layer riêng. Tag là tên có thể được cập nhật, không phải bằng chứng byte-for-byte bất biến; digest nhận diện nội dung.

## 3. Ví dụ nhỏ

Demo dùng build image Maven/JDK 17 để tạo JAR rồi runtime image JRE 17 để chạy. Hai stage không tạo hai service runtime.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: class/JAR được copy vào image; JVM nằm trong base runtime image. HTTP: image chưa nghe port khi chưa có container process. SQL: image postgres 17 chứa server software, dữ liệu runtime nằm ở volume.

## 5. Những lỗi thường gặp

Tưởng image có dữ liệu DB cá nhân; dùng tag latest rồi nghĩ luôn ổn định; sửa container filesystem rồi nghĩ image đã thay đổi; build image khi JAR chưa có theo cách copy thủ công.

## 6. Câu hỏi tự kiểm tra

Image có đang chạy không? Vì sao tag có thể đổi nhưng digest không? Multi-stage khác hai container runtime thế nào?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
