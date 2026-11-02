# Environment variable: cấu hình của process

## 1. Problem — tại sao khái niệm tồn tại

Không nên hardcode DB host/password theo mỗi máy trong source. Process cần nhận cấu hình từ môi trường chạy.

## 2. Mental model

Environment là cặp key/value mà child process kế thừa lúc được tạo. Thay biến ở shell hiện tại không tự đổi environment của process đã chạy. Biến shell chưa export không mặc định thành environment cho child.

## 3. Ví dụ nhỏ

Bash: `export APP_LABEL=learning`; Java đọc `System.getenv("APP_LABEL")`. Spring ánh xạ biến như SPRING_DATASOURCE_URL sang property datasource.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: getenv khác property -D và khác args. HTTP: header Authorization thuộc request, không phải environment process. SQL: DB URL/username/password là cấu hình kết nối; schema/row nằm trong DB.

## 5. Những lỗi thường gặp

Đổi env rồi không recreate/restart app; in toàn bộ env lộ secret; nghĩ .env tự được mọi chương trình đọc; hardcode mật khẩu thật.

## 6. Câu hỏi tự kiểm tra

export có tác dụng gì? Process đang chạy có tự nhận giá trị mới không? .env là file hay environment thật?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
