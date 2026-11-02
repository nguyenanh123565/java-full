# 12 — Relationships: mô hình hóa quan hệ giữa dữ liệu

## Khái niệm giải quyết vấn đề gì?

Một user có nhiều orders; một category có nhiều products. Một order có nhiều products và một product xuất hiện trong nhiều orders. Tách bảng tránh lặp dữ liệu của user/product, đồng thời lưu được sự kiện mua hàng độc lập với thông tin hiện tại.

## SQL hoạt động như thế nào?

- Quan hệ một–nhiều: khóa của bảng cha xuất hiện trong FK của bảng con, ví dụ `orders.user_id → users.id`.
- Quan hệ nhiều–nhiều: dùng bảng nối `order_items`, có `order_id` và `product_id`. Quantity và giá lúc mua thuộc quan hệ mua hàng nên nằm ở đây.
- `UNIQUE (order_id, product_id)` trong workspace cho phép tối đa một dòng cho cùng sản phẩm trong một order; quantity thể hiện số lượng.
- Khi JOIN, mỗi cặp dòng khớp điều kiện tạo một dòng kết quả. Nối user → orders → items có thể lặp tên user nhiều lần. Mỗi dòng kết quả lúc này đại diện một item, không còn một user.

ID ở các bảng khác nhau có thể tình cờ bằng nhau; điều đó không chứng minh chúng có quan hệ. FK và ý nghĩa nghiệp vụ xác định khóa nối.

## Ví dụ

```sql
SELECT o.id, u.name, oi.product_id, oi.quantity, oi.price
FROM orders AS o
JOIN users AS u ON u.id = o.user_id
JOIN order_items AS oi ON oi.order_id = o.id
WHERE o.id = 1;
```

Seed có hai dòng chi tiết ở order 1, nên order và tên user xuất hiện hai lần. `oi.price` giữ giá lịch sử; thay đổi `products.price` không nên đổi lịch sử mua hàng.

## Lỗi người mới hay mắc

- Lưu danh sách product ID trong một chuỗi của orders thay cho bảng nối.
- JOIN `users.id = orders.id` vì tên cột giống nhau.
- Cho rằng tên user lặp trong kết quả là dữ liệu gốc bị trùng.
- Tính tiền lịch sử bằng giá hiện tại ở products.
- Nghĩ FK tự đồng bộ `orders.total` với order_items hoặc tự xóa mọi bảng con.

## Câu hỏi kiểm tra hiểu biết

1. Cột nào đứng ở phía “nhiều” của quan hệ users–orders?
2. Vì sao quantity và giá lúc mua thuộc order_items?
3. UNIQUE(order_id, product_id) cho phép cùng product xuất hiện trong hai order khác nhau không?
4. Sau khi JOIN order 1 với items, một dòng đại diện cho đối tượng nào?
5. Vì sao không nối các bảng chỉ bằng hai cột đều có tên id?

## Bài tập

Trong `exercise.sql`, lần lượt truy xuất quan hệ một–nhiều, chi tiết đơn và quan hệ nhiều–nhiều. Trước mỗi query, ghi rõ mỗi dòng đầu ra đại diện gì. Lời giải nằm ở `../solutions/12-relationships.sql`.
