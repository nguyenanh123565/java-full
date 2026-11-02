# Process: chương trình đang thực thi

## 1. Problem — tại sao khái niệm tồn tại

Có JAR trên disk chưa có nghĩa API đang chạy. Cần biết process nào thực thi, còn sống hay đã thoát.

## 2. Mental model

Program/JAR là file; process là một lần OS chạy program, có PID, bộ nhớ, environment và tài nguyên. Một JAR có thể có nhiều process chạy với cấu hình khác nhau.

## 3. Ví dụ nhỏ

`ps` liệt kê process. `sleep 30` tạo process thử nhẹ. Chỉ gửi TERM cho PID mà chính demo vừa tạo; không kill tiến trình Java/PostgreSQL khác.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: `java -jar` tạo JVM process, nhiều thread trong cùng PID. HTTP: process server bind port rồi nhận request. SQL: JDBC client nằm trong Java process; PostgreSQL server process riêng.

## 5. Những lỗi thường gặp

Tưởng build xong là process đã chạy; nhầm thread với process; kill theo tên rộng; chạy thêm app rồi chiếm cổng.

## 6. Câu hỏi tự kiểm tra

Process và file khác gì? Một JVM có nhiều thread không? App thoát thì port listener thường còn không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
