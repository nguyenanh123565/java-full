# Port: địa chỉ dịch vụ trên một host

## 1. Problem — tại sao khái niệm tồn tại

Máy có nhiều server; IP xác định host, port giúp chọn listener. Lỗi connect thường nằm trước controller.

## 2. Mental model

Server bind address+port; client kết nối host:port qua giao thức. HTTP thường trên TCP; PostgreSQL dùng giao thức riêng, không phải HTTP dù cũng có port.

## 3. Ví dụ nhỏ

App demo nghe 8080 trong container, publish 8081 trên host. PostgreSQL nghe 5432 trong mạng Compose nhưng không publish host.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: embedded server mở socket khi process start. HTTP: curl dùng host/port rồi mới gửi method/path. SQL: JDBC URL db:5432 kết nối protocol PostgreSQL, không curl được endpoint REST ở đó.

## 5. Những lỗi thường gặp

Nhầm port host với container; cho rằng EXPOSE publish port; dùng localhost từ app container để tìm DB container; curl vào 5432 rồi kết luận DB hỏng.

## 6. Câu hỏi tự kiểm tra

Listener và route khác gì? 404 chứng minh đã tới HTTP server chưa? Hai process có thể bind cùng address:port thông thường không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
