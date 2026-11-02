# Port mapping: host 8081 → container 8080

## 1. Problem — tại sao khái niệm tồn tại

HTTP server bên trong container không tự hiện trên mọi port host. Cần đường vào từ client ngoài network container.

## 2. Mental model

Mapping `HOST_IP:HOST_PORT:CONTAINER_PORT` nối listener host tới port trong container. Các service cùng Compose dùng service name và container port; không dùng host port vòng ra ngoài.

## 3. Ví dụ nhỏ

Compose demo publish `127.0.0.1:8081:8080`; curl host gọi 8081. App truy cập `db:5432` nội bộ; DB không cần publish port.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: server.port=8080 định port app bind. HTTP: URI client host phải có 8081. SQL: JDBC URL dùng db:5432, không 8081 hoặc localhost 5432 trong app container.

## 5. Những lỗi thường gặp

Đảo host/container port; đổi mapping rồi sửa nhầm JDBC URL; dùng localhost từ app để chỉ DB; tưởng EXPOSE 8080 tương đương ports.

## 6. Câu hỏi tự kiểm tra

Vì sao curl 8081 đúng nhưng app vẫn nghe 8080? Service DNS db dùng trong host terminal được mặc định không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
