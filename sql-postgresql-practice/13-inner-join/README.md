# 13 — INNER JOIN: kết hợp các dòng có liên hệ

## Khái niệm giải quyết vấn đề gì?

API thường cần thông tin từ nhiều bảng: danh sách order kèm tên người mua, sản phẩm kèm category, chi tiết đơn kèm tên product. INNER JOIN chỉ lấy những cặp dòng khớp điều kiện, giúp tạo kết quả từ dữ liệu được tách hợp lý.

## SQL hoạt động như thế nào?

Về mặt logic, `FROM ... JOIN ... ON` tạo các cặp khớp; `WHERE` lọc tiếp, `SELECT` chọn cột, `ORDER BY` sắp xếp. PostgreSQL có thể đổi kế hoạch thực thi để tối ưu, nhưng phải giữ ý nghĩa kết quả. INNER JOIN bỏ dòng không có đối tác khớp. Nếu một order có ba items, JOIN đó cho ba dòng của order.

Nối theo FK: `orders.user_id = users.id`, `products.category_id = categories.id`, `order_items.order_id = orders.id`, `order_items.product_id = products.id`. Dùng alias và đặt tên cột đầu ra giúp tránh nhầm các cột `id`.

## Ví dụ

```sql
SELECT p.id, p.name, c.name AS category_name
FROM products AS p
JOIN categories AS c ON c.id = p.category_id
WHERE c.name = 'robot'
ORDER BY p.id;
```

Chỉ products có category robot được giữ. FK/NOT NULL bảo đảm mỗi product có category hợp lệ trong schema này.

## Lỗi người mới hay mắc

- Nối `orders.id = users.id` thay vì `orders.user_id = users.id`.
- Quên ON, tạo tổ hợp mọi dòng bằng CROSS JOIN hoặc dấu phẩy trong FROM.
- Dùng `SELECT *` khiến nhiều cột id/name khó phân biệt.
- Mong INNER JOIN trả cả user chưa mua hàng; trường hợp đó cần LEFT JOIN.
- SUM orders.total sau khi JOIN items: tổng order bị tính lặp theo số items.

## Câu hỏi kiểm tra hiểu biết

1. User chưa có order có xuất hiện trong INNER JOIN users–orders không?
2. Order có hai items sẽ tạo bao nhiêu dòng khi JOIN orders–items?
3. ON khác WHERE về vai trò logic như thế nào?
4. Vì sao không SUM orders.total trực tiếp sau khi JOIN order_items?
5. Trong schema này, INNER JOIN products–categories có bỏ product hợp lệ không? Vì sao?

## Bài tập

Hoàn thành ba TODO trong `exercise.sql`. Đánh dấu ý nghĩa mỗi dòng trước khi đếm hoặc cộng dữ liệu. Đối chiếu ở `../solutions/13-inner-join.sql`.
