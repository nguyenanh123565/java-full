# 15 — Aggregate functions: từ nhiều dòng thành một con số

## Khái niệm giải quyết vấn đề gì?

Backend cần tổng số sản phẩm, giá trung bình, số đơn, tổng tiền hoặc số lượng bán. Hàm tổng hợp nhận nhiều dòng và tính một giá trị, giúp database trả kết quả báo cáo mà Java không phải tải mọi dòng về để cộng.

## SQL hoạt động như thế nào?

Sau FROM/JOIN và WHERE, aggregate xử lý các dòng còn lại. Nếu không có GROUP BY, tất cả dòng đó là một nhóm và query tổng hợp vẫn trả một dòng khi đầu vào rỗng.

- `COUNT(*)` đếm dòng; `COUNT(column)` bỏ NULL; `COUNT(DISTINCT column)` đếm giá trị khác nhau không NULL.
- `SUM`, `AVG`, `MIN`, `MAX` bỏ qua NULL. Với đầu vào rỗng, chúng trả NULL; COUNT trả 0.
- `COALESCE(SUM(...), 0)` là lựa chọn khi nghiệp vụ cần số 0 cho tập rỗng.
- `AVG(price)` là trung bình giá mỗi dòng, không phải giá trung bình theo số lượng bán. Trung bình theo quantity cần `SUM(quantity * price) / SUM(quantity)`.

Phải xác định “mỗi dòng là gì” trước khi cộng. JOIN orders với order_items làm total của order xuất hiện nhiều lần. Tính tiền từ `quantity * order_items.price` hoặc tính orders.total trên chính bảng orders.

## Ví dụ

```sql
SELECT COUNT(*) AS item_count,
       SUM(quantity) AS unit_count,
       SUM(quantity * price) AS order_total
FROM order_items
WHERE order_id = 1;
```

Seed cho 2 dòng item, 3 đơn vị sản phẩm và tổng 8.900.000. Ba con số đo ba điều khác nhau.

## Lỗi người mới hay mắc

- Nhầm số dòng chi tiết với số lượng sản phẩm hoặc số order.
- Nghĩ SUM không có dòng sẽ trả 0.
- Dùng COUNT(*) sau LEFT JOIN để đếm đối tượng ở bảng phải.
- Dùng giá hiện tại ở products để báo cáo tiền của đơn cũ.
- Không định nghĩa trạng thái nào được tính doanh thu. Trong bài này, chỉ `paid` và `shipped` được tính; `pending` và `cancelled` bị loại.

## Câu hỏi kiểm tra hiểu biết

1. COUNT, SUM trả gì khi WHERE không tìm thấy dòng nào?
2. Vì sao order 1 có 2 items nhưng bán 3 đơn vị sản phẩm?
3. Sau JOIN items, dùng COUNT(DISTINCT o.id) để giải quyết vấn đề gì?
4. AVG(oi.price) khác giá trung bình theo số lượng ở đâu?
5. Vì sao phải quyết định status nào được tính trước khi cộng doanh thu?

## Bài tập

Ba TODO trong `exercise.sql`: thống kê giá, tính doanh thu từ lịch sử và quan sát tập thiếu order. Đối chiếu riêng tại `../solutions/15-aggregate-functions.sql`.
