# Spring Boot Product API

Điều kiện: JDBC + Maven + Spring MVC/DI/DTO/validation/error. Chưa đủ điều kiện thì quay lại workspace nền tảng trước.

## 1. Problem
Routing/JSON/validation thủ công làm lặp code; giữ logic Java và giao việc HTTP chung cho framework.

## 2. Mental model
HTTP → Controller/DTO → Service → Repository interface → Map (chặng đầu) / JDBC (chặng sau).

## 3. Ví dụ nhỏ
POST /products hợp lệ trả 201 + Location; GET ID vừa tạo trả 200; input sai trả 400.
Xem [demo](demo/README.md).

## 4. Liên hệ kiến thức cũ
Tự giải thích mỗi annotation thay phần Java HTTP thuần nào; repository vẫn là interface Java, chưa cần JPA.

## 5. Lỗi thường gặp
Cho controller viết SQL; trả entity trực tiếp; bắt tất cả lỗi thành 200; thêm JPA trước khi hiểu repository.

## 6. Câu hỏi tự kiểm tra
Vì sao service không nên phụ thuộc HttpServletRequest? Vì sao DTO có thể khác Product?

## 7. Exercise và tiêu chí hoàn thành
Tự làm CRUD REST với DTO, validation, 400/404; bắt đầu Map rồi đổi sang JDBC DAO sau khi HTTP đã đúng.
Đủ CRUD, request contract và test hành vi; chạy lại không làm thay đổi bài cũ; hiểu dữ liệu Map mất sau restart.
Làm [exercise](exercise/README.md), ghi [notes](notes.md), rồi đối chiếu
[solution riêng](solution/README.md). Dùng [checklist](../project-checklists/README.md).
