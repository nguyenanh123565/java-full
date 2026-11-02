# Java CLI Product Management

Điều kiện: Java Core: class, method, collection, exception; Git commit. Chưa đủ điều kiện thì quay lại workspace nền tảng trước.

## 1. Problem
Tách input console khỏi thao tác trên product để không lặp logic ở mọi menu.

## 2. Mental model
Scanner → parse command → service → Map<Long, Product> → console output.

## 3. Ví dụ nhỏ
Thêm product rồi list/find/update/delete; khởi động lại thì Map mất dữ liệu.
Xem [demo](demo/README.md).

## 4. Liên hệ kiến thức cũ
Java object là dữ liệu trong heap; chưa có HTTP hay SQL. Cùng validation sẽ dùng lại ở service REST và CHECK constraint.

## 5. Lỗi thường gặp
Dùng double cho tiền; nextInt rồi nextLine mất dòng; không phân biệt ID và vị trí list.

## 6. Câu hỏi tự kiểm tra
Vì sao tắt chương trình thì mất product? Nếu hai product trùng tên thì ID xử lý thế nào?

## 7. Exercise và tiêu chí hoàn thành
Viết CLI CRUD bằng Map; giá và stock không âm, name không rỗng; in thông báo khi ID thiếu.
CRUD chạy trong một process; input sai không làm app tắt; có ít nhất 8 case tự kiểm.
Làm [exercise](exercise/README.md), ghi [notes](notes.md), rồi đối chiếu
[solution riêng](solution/README.md). Dùng [checklist](../project-checklists/README.md).
