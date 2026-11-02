# Luyện tập tổng hợp và báo cáo

## Khái niệm giải quyết vấn đề gì?

Một báo cáo trả lời câu hỏi theo nhóm: bao nhiêu sản phẩm trong từng danh mục, bao nhiêu đơn của từng user hoặc sản phẩm nào được đặt nhiều nhất. Trước khi tổng hợp, xác định **đơn vị của từng dòng đầu vào** và **đơn vị của từng nhóm kết quả**.

## SQL hoạt động như thế nào?

`WHERE` lọc dòng trước khi tạo nhóm; `GROUP BY` gom các dòng có cùng khóa nhóm; `COUNT`, `SUM`, `AVG`, `MIN`, `MAX` rút nhóm thành giá trị; `HAVING` lọc nhóm sau tổng hợp. `COUNT(*)` đếm dòng; `COUNT(cột)` bỏ qua NULL. `SUM` trên tập rỗng trả NULL; `COALESCE` có thể biểu diễn bằng 0 theo yêu cầu nghiệp vụ.

JOIN một đơn với nhiều dòng hàng làm lặp `orders.total`. Cộng tổng đơn phải thực hiện trên bảng `orders`, hoặc tổng hợp về một dòng mỗi đơn trước. `SUM(DISTINCT total)` cũng sai khi hai đơn thực sự có cùng giá trị.

## Ví dụ và cách chạy

```sql
SELECT status, COUNT(*) AS order_count, SUM(total) AS order_value
FROM orders
GROUP BY status
ORDER BY status;
```

Đây là giá trị đơn theo trạng thái, chưa đồng nghĩa doanh thu đã thu tiền. Trong bài tập, “không hủy” gồm `pending`, `paid`, `shipped`; nếu báo cáo doanh thu thực thu, cần định nghĩa trạng thái phù hợp trước. Nạp database rồi chạy:

```powershell
psql -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f exercises/aggregation/demo.sql
```

## Lỗi người mới hay mắc

- Dùng `WHERE COUNT(*) > 1` thay cho `HAVING`.
- Chọn cột không thuộc GROUP BY và không nằm trong aggregate.
- Dùng `COUNT(*)` trên LEFT JOIN rồi đếm user chưa mua hàng thành một đơn.
- Cộng `orders.total` sau khi JOIN `order_items`, làm tăng sai tổng tiền.
- Hiểu `COUNT(order_items.id)` là số lượng sản phẩm, trong khi số lượng là `SUM(quantity)`.

## Câu hỏi kiểm tra hiểu biết

1. `WHERE` và `HAVING` lọc ở hai giai đoạn nào?
2. Vì sao `COUNT(o.id)` có thể bằng 0 nhưng `COUNT(*)` bằng 1 với LEFT JOIN?
3. Hai đơn cùng total có khiến `SUM(DISTINCT total)` sai không?
4. Vì sao điều kiện loại đơn hủy nên nằm trong ON khi cần giữ mọi user?
5. Số dòng hàng và tổng số đơn vị sản phẩm khác nhau thế nào?

## Bài tập

Năm TODO: thống kê sản phẩm; tổng hợp theo danh mục; tổng đơn của từng user; lọc nhóm với HAVING; xếp hạng sản phẩm theo số lượng đặt. Giải thích đơn vị của từng cột số liệu. Solutions: `../../solutions/exercises/aggregation.sql`.
