# Logs: bằng chứng về lúc app thực thi

## 1. Problem — tại sao khái niệm tồn tại

Response 500 chỉ nói request thất bại; cần timestamp/lỗi để tìm lớp hỏng. Log giúp quan sát tiến trình đang chạy.

## 2. Mental model

App ghi event ra stdout/stderr hoặc file; container runtime thu các luồng đó. Đọc log để tìm nguyên nhân cùng thời điểm request; không suy mọi dòng ERROR là cùng một lỗi.

## 3. Ví dụ nhỏ

Log startup có port app; lỗi kết nối DB có host/exception; SQL syntax error khác connection refused. `tail` xem cuối file; Compose logs xem stdout/stderr service.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: exception stack trace chỉ nơi code lỗi. HTTP: status 500 là bề mặt, log cho nguyên nhân nội bộ. SQL: lỗi constraint/query khác lỗi mạng DB, cần đọc message cụ thể.

## 5. Những lỗi thường gặp

Chỉ nhìn response rồi đoán; log password/token; bỏ qua timestamp; chạy lại nhiều lần làm mất mốc quan sát; nghĩ log nằm trong row DB.

## 6. Câu hỏi tự kiểm tra

Stdout của container nằm ở đâu để đọc? Vì sao không trả stack trace cho client? Log nào giúp phân biệt port và schema?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
