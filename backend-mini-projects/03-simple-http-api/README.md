# Simple HTTP API bằng Java thuần

Điều kiện: Project 01 + HTTP method/URL/status/JSON. Chưa đủ điều kiện thì quay lại workspace nền tảng trước.

## 1. Problem
Client không thể gọi trực tiếp method Java chạy ở process khác; cần hợp đồng HTTP.

## 2. Mental model
TCP/HTTP server → kiểm method/path → gọi logic → status/header/JSON response.

## 3. Ví dụ nhỏ
GET /products/1 trả JSON; ID không có trả 404; method không được hỗ trợ trả 405.
Xem [demo](demo/README.md).

## 4. Liên hệ kiến thức cũ
Map Java thay DB ở bước đầu; route/mapping/serialize thủ công là công việc Spring MVC sẽ hỗ trợ sau.

## 5. Lỗi thường gặp
Mọi route đều 200; dùng String.length thay byte length UTF-8; quên close exchange.

## 6. Câu hỏi tự kiểm tra
Vì sao cần Content-Type? Vì sao query string không phải một phần của path parameter?

## 7. Exercise và tiêu chí hoàn thành
Tạo HTTP API read-only GET /products và GET /products/{id}; thêm 400/404/405 có body rõ.
curl kiểm status/header/body; không thêm Spring/JPA; mô tả rõ giới hạn read-only trước khi mở rộng CRUD.
Làm [exercise](exercise/README.md), ghi [notes](notes.md), rồi đối chiếu
[solution riêng](solution/README.md). Dùng [checklist](../project-checklists/README.md).
