# Luyện tập nhập môn SQL

## Khái niệm giải quyết vấn đề gì?

Một query trả lời một câu hỏi về dữ liệu. Bắt đầu bằng câu hỏi “mỗi dòng kết quả đại diện cho điều gì?” trước khi chọn cột. Bảng lưu dữ liệu; kết quả `SELECT` là một tập dòng được tạo cho lần truy vấn đó.

## SQL hoạt động như thế nào?

`FROM` xác định nguồn; `SELECT` chọn cột hoặc biểu thức. Không có `ORDER BY`, PostgreSQL không đảm bảo thứ tự dòng. `DISTINCT` loại những dòng trùng trên **toàn bộ các cột được chọn**. `AS` đặt tên cột kết quả, không đổi tên cột trong bảng.

## Ví dụ và cách chạy

Nạp `database/schema.sql` và `database/seed.sql` vào database `sql_postgresql_practice`, rồi mở `demo.sql`. Trước khi chạy, đoán giá trị `inventory_value` khi một sản phẩm có `stock = 0`:

```sql
SELECT id, name, price * stock AS inventory_value
FROM products
ORDER BY id;
```

Chạy bằng psql từ thư mục gốc workspace:

```powershell
psql -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f exercises/beginner/demo.sql
```

## Lỗi người mới hay mắc

- Dùng `SELECT *` rồi phụ thuộc thứ tự cột khi viết backend.
- Cho rằng kết quả luôn tự sắp xếp theo khóa chính.
- Nhầm biểu thức trong kết quả với thao tác cập nhật dữ liệu.
- Cho rằng `DISTINCT status, id` chỉ loại trùng riêng cột `status`.

## Câu hỏi kiểm tra hiểu biết

1. `SELECT price * stock` có thay đổi `price` trong bảng không? Vì sao?
2. Một dòng trong kết quả sản phẩm đại diện cho điều gì?
3. Tại sao hai lần chạy cùng query có thể thấy thứ tự dòng khác nhau?
4. `DISTINCT status` khác `DISTINCT status, id` ở đâu?
5. Vì sao backend nên chọn rõ các cột cần trả về?

## Bài tập

Làm lần lượt bốn TODO trong `exercise.sql`: đọc users, đọc products, tính giá trị tồn kho và xem các trạng thái đơn hàng. Với mỗi bài, mô tả ý nghĩa một dòng kết quả và giải thích query. Chỉ mở `../../solutions/exercises/beginner.sql` sau khi tự thử.
