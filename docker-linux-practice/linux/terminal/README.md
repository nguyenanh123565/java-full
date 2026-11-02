# Terminal: gọi command và quan sát kết quả

## 1. Problem — tại sao khái niệm tồn tại

Backend cần kiểm tra process/log/API mà không dựa hoàn toàn IDE. Cần hiểu command nhận argument và shell chuyển dữ liệu.

## 2. Mental model

Terminal là giao diện; shell đọc command. Command có arguments, stdout, stderr và exit status. Pipe chuyển stdout sang stdin command sau, không tự bảo đảm nội dung hợp lệ.

## 3. Ví dụ nhỏ

`pwd`, `ls`, `cat`, `tail` để quan sát; `curl -i URL` gửi HTTP và hiện status/header/body. `curl -i` mặc định vẫn có thể exit 0 cho HTTP 404; lỗi HTTP khác lỗi kết nối.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: args[] là arguments, System.out/System.err là hai luồng. HTTP: 200/404/500 là status giao thức, khác exit status curl. SQL: psql là client terminal, DB server vẫn là process khác.

## 5. Những lỗi thường gặp

Copy command mà không hiểu path; dán Bash vào PowerShell; nghĩ curl exit 0 nghĩa HTTP 200; nhầm pipe với thực thi tuần tự mọi command.

## 6. Câu hỏi tự kiểm tra

Stdout khác stderr ở đâu? `curl` không kết nối được khác response 404 thế nào? Vì sao cần quote path có khoảng trắng?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
