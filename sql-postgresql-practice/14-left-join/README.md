# 14 — LEFT JOIN: giữ cả dữ liệu chưa có đối tác

## Khái niệm giải quyết vấn đề gì?

Một báo cáo cần hiển thị cả user chưa mua hàng hoặc product chưa bán. INNER JOIN làm các dòng này biến mất; LEFT JOIN giữ tất cả dòng bên trái và bổ sung dữ liệu bên phải nếu có.

## SQL hoạt động như thế nào?

Về logic, PostgreSQL tìm những dòng bên phải thỏa ON. Nếu không có dòng nào, LEFT JOIN tạo một dòng kết quả với các cột bên phải là NULL. NULL này do JOIN tạo ra, dù các cột gốc đều có NOT NULL.

WHERE được xét sau JOIN. `WHERE o.status = 'paid'` loại cả dòng có `o.status = NULL`, vì so sánh đó trả UNKNOWN. Đặt `AND o.status = 'paid'` trong ON sẽ chỉ chọn order paid nhưng vẫn giữ user không có order paid.

`COUNT(*)` đếm cả dòng giữ chỗ. `COUNT(o.id)` chỉ đếm id không NULL, nên trả 0 cho user không có order. Dùng `o.id IS NULL` để tìm user không có order, vì id của một order thật không thể NULL.

## Ví dụ

```sql
SELECT u.id, u.name, o.id AS paid_order_id
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id AND o.status = 'paid'
ORDER BY u.id, o.id;
```

Users 11 và 12 vẫn xuất hiện với paid_order_id NULL. Đây là “mọi user và order paid nếu có”, khác với “chỉ user có order paid”.

## Lỗi người mới hay mắc

- Viết `o.id = NULL`; phải dùng `IS NULL`.
- Chuyển điều kiện của bảng phải từ ON sang WHERE mà không xét user cần giữ.
- Dùng COUNT(*) để đếm orders sau LEFT JOIN.
- Nghĩ NOT NULL trong schema cấm NULL xuất hiện trong kết quả LEFT JOIN.
- Nghĩ LEFT JOIN luôn trả đúng một dòng cho mỗi user; user có nhiều order vẫn tạo nhiều dòng.

## Câu hỏi kiểm tra hiểu biết

1. User chưa có order tạo bao nhiêu dòng sau LEFT JOIN users–orders?
2. Cột orders.id là NOT NULL, vì sao kết quả JOIN vẫn có NULL?
3. Lọc status paid trong ON khác lọc trong WHERE như thế nào?
4. COUNT(*) và COUNT(o.id) khác nhau ở user chưa mua hàng ra sao?
5. Vì sao dùng o.id IS NULL thay vì o.status IS NULL để phát hiện không có order?

## Bài tập

Ba TODO trong `exercise.sql` đi từ giữ mọi user tới tìm dữ liệu thiếu và đếm order có điều kiện. Bài 3 dùng GROUP BY, có thể quay lại sau bài 16. Lời giải: `../solutions/14-left-join.sql`.
