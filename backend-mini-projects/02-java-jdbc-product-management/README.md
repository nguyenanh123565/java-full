# Java + JDBC Product Management

Điều kiện: Project 01 + SQL + JDBC CRUD/transaction. Chưa đủ điều kiện thì quay lại workspace nền tảng trước.

## 1. Problem
Map mất dữ liệu sau khi tắt app và không có constraint bảo vệ giữa nhiều client.

## 2. Mental model
Console → service → ProductDao → JDBC driver → PostgreSQL → ResultSet → Product.

## 3. Ví dụ nhỏ
Tạo product, tắt CLI, mở lại và tìm bằng ID đã tạo.
Xem [demo](demo/README.md).

## 4. Liên hệ kiến thức cũ
Giữ nguyên model/validation Java; thay Map bằng DAO; dùng SQL parameter và try-with-resources đã học.

## 5. Lỗi thường gặp
Nối input vào SQL; không đóng ResultSet; nuốt SQLException; dùng chung connection global.

## 6. Câu hỏi tự kiểm tra
Vì sao PreparedStatement không thay tên table bằng dấu ? được? Ai rollback khi nhiều query cùng thất bại?

## 7. Exercise và tiêu chí hoàn thành
Thực hiện add/list/find/update/delete bằng PreparedStatement, tách ProductDao khỏi menu.
Dữ liệu tồn tại sau restart; SQL Injection trong name chỉ là dữ liệu; UPDATE/DELETE ID thiếu được báo rõ.
Làm [exercise](exercise/README.md), ghi [notes](notes.md), rồi đối chiếu
[solution riêng](solution/README.md). Dùng [checklist](../project-checklists/README.md).
