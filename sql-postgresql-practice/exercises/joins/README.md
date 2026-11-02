# Luyện tập JOIN và quan hệ

## Khái niệm giải quyết vấn đề gì?

JOIN ghép dữ liệu liên quan nằm ở nhiều bảng: sản phẩm thuộc danh mục, đơn hàng thuộc user, dòng đơn hàng trỏ tới sản phẩm. Khóa ngoại mô tả quan hệ; điều kiện JOIN phải đi theo quan hệ đó, không theo hai cột tình cờ có cùng tên.

## SQL hoạt động như thế nào?

`INNER JOIN` tạo dòng cho từng cặp khớp điều kiện `ON`. `LEFT JOIN` còn giữ dòng bên trái không có cặp bên phải và điền `NULL` vào các cột bên phải. Một đơn có hai `order_items` sẽ xuất hiện hai lần khi JOIN: mỗi dòng lúc này đại diện cho **một dòng hàng**. Cột `order_items.price` là giá tại lúc đặt hàng; `products.price` là giá hiện tại.

## Ví dụ và cách chạy

```sql
SELECT o.id AS order_id, oi.id AS item_id, p.name, oi.price
FROM orders o
JOIN order_items oi ON oi.order_id = o.id
JOIN products p ON p.id = oi.product_id
WHERE o.id = 1
ORDER BY oi.id;
```

Dự đoán số dòng dựa vào các dòng hàng của đơn 1, rồi chạy `demo.sql` sau khi nạp database:

```powershell
psql -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f exercises/joins/demo.sql
```

## Lỗi người mới hay mắc

- JOIN `orders.id = users.id` thay vì `orders.user_id = users.id`.
- Tưởng JOIN luôn giữ nguyên số dòng của bảng bên trái.
- Đặt điều kiện trên bảng phải vào `WHERE` khiến LEFT JOIN loại những dòng không khớp.
- Dùng giá hiện tại của sản phẩm để hiển thị hóa đơn lịch sử.
- Dùng `DISTINCT` che quan hệ một-nhiều mà không xác định một dòng kết quả nghĩa là gì.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao INNER JOIN users và orders không giữ user chưa mua hàng?
2. Vì sao JOIN một đơn với hai dòng hàng tạo hai dòng kết quả?
3. `NULL` xuất hiện từ LEFT JOIN có đồng nghĩa bảng gốc chứa NULL không?
4. Điều kiện ở `ON` và `WHERE` có luôn tương đương với LEFT JOIN không?
5. Khi giá sản phẩm đổi, nên lấy cột nào để đọc giá mua của đơn cũ?

## Bài tập

Năm TODO đi từ đọc tên danh mục tới đọc chi tiết đơn, giữ user chưa mua hàng và tìm dữ liệu chưa từng xuất hiện trong giao dịch. “Chưa từng được đặt” trong bộ bài này nghĩa là không xuất hiện ở bất kỳ `order_items` nào, kể cả đơn đã hủy. Không đồng nhất điều đó với “chưa bán thành công”. Solutions: `../../solutions/exercises/joins.sql`.
