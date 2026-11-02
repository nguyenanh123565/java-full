# E-commerce Backend monolith nhỏ

Điều kiện: Project 04 + JPA + Security + Testing + Docker/Linux cơ bản. Chưa đủ điều kiện thì quay lại workspace nền tảng trước.

## 1. Problem
Tạo order liên quan nhiều row; tổng tiền, tồn kho và quyền truy cập phải nhất quán.

## 2. Mental model
HTTP Request → Controller → Service → Repository → JPA/Hibernate → PostgreSQL → Response.

## 3. Ví dụ nhỏ
POST /orders đọc giá từ DB, chụp unit_price vào order_items, trừ stock và tạo order trong một transaction.
Xem [demo](demo/README.md).

## 4. Liên hệ kiến thức cũ
Collection/BigDecimal/exception Java; HTTP status và quyền; SQL FK/CHECK/JOIN/transaction; JDBC vẫn nằm dưới ORM.

## 5. Lỗi thường gặp
Tin total/price từ client; cho user đọc order của người khác; cập nhật stock bằng read-then-write thiếu bảo vệ đồng thời.

## 6. Câu hỏi tự kiểm tra
Vì sao order_items lưu unit_price? Vì sao hai request cùng mua item cuối cần atomic update hoặc lock?

## 7. Exercise và tiêu chí hoàn thành
Tự thiết kế users/categories/products/orders/order_items, API theo contract, role USER/ADMIN và transaction tạo order.
Không oversell; item hai lỗi rollback item một; order total tính trên server; owner hoặc ADMIN mới đọc order.
Làm [exercise](exercise/README.md), ghi [notes](notes.md), rồi đối chiếu
[solution riêng](solution/README.md). Dùng [checklist](../project-checklists/README.md).
