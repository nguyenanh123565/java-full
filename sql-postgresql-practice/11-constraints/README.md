# 11 — Constraints: bảo vệ dữ liệu ngay tại database

## Khái niệm giải quyết vấn đề gì?

Nhiều API có thể cùng ghi dữ liệu. Constraints giữ các quy tắc tối thiểu ngay cả khi một chương trình quên kiểm tra: email không trùng, giá không âm, số lượng mua lớn hơn 0 và khóa ngoại phải tồn tại. Kiểm tra ở Java giúp thông báo dễ hiểu; kiểm tra ở database giữ dữ liệu nhất quán.

## SQL hoạt động như thế nào?

- `PRIMARY KEY` nhận diện duy nhất một dòng, đồng thời cấm `NULL`.
- `NOT NULL` yêu cầu có giá trị; chuỗi rỗng `''` vẫn là một giá trị.
- `UNIQUE` cấm giá trị trùng. Mặc định PostgreSQL cho phép nhiều `NULL` trong cột UNIQUE; `email` của workspace có cả `UNIQUE` và `NOT NULL`.
- `FOREIGN KEY` bảo vệ liên kết tới dòng cha. Nó không tự tạo index trên cột của bảng con.
- `CHECK` xét từng dòng khi ghi. Biểu thức CHECK trả về `TRUE` hoặc `UNKNOWN` đều được chấp nhận; muốn cấm NULL cần thêm `NOT NULL`.

Một lệnh INSERT nhiều dòng thất bại thì toàn bộ lệnh đó không được áp dụng. Trong transaction, một lỗi làm transaction ở trạng thái lỗi cho đến khi `ROLLBACK` hoặc rollback tới savepoint.

## Ví dụ

```sql
CREATE TEMP TABLE cart_guard (
    quantity integer NOT NULL CHECK (quantity > 0),
    price numeric(14, 2) NOT NULL CHECK (price >= 0)
);
```

`quantity = 0` bị từ chối. `price = NULL` cũng bị từ chối nhờ NOT NULL. Xem `demo.sql`; các câu cố tình sai được đặt trong comment để bạn chủ động thử riêng.

## Lỗi người mới hay mắc

- Nghĩ CHECK dương sẽ tự cấm NULL.
- Nghĩ UNIQUE thay thế được NOT NULL hoặc xử lý email hoa/thường. UNIQUE email dạng text hiện tại phân biệt chữ hoa/thường.
- Nghĩ FK tự tính `orders.total`. Tổng đơn hàng là quy tắc giữa nhiều dòng; CHECK/FK trong schema này không tự cộng `order_items`.
- Chỉ kiểm tra tại Java, khiến một luồng ghi khác có thể tạo dữ liệu sai.
- Tiếp tục chạy SQL sau lỗi trong transaction mà chưa rollback.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao `CHECK (stock >= 0)` và `NOT NULL` cần tồn tại cùng nhau?
2. PRIMARY KEY khác UNIQUE ở điểm nào?
3. Một dòng `order_items` có thể trỏ tới order không tồn tại không? Quy tắc nào quyết định?
4. Vì sao CHECK/FK không bảo đảm `orders.total` bằng tổng các dòng chi tiết?
5. Trong transaction, bạn cần làm gì sau một lệnh vi phạm constraint?

## Bài tập

Làm ba TODO trong `exercise.sql`: xem constraints thật, thiết kế bảng tạm và kiểm tra tổng đơn. Bài sau khó hơn bài trước. Viết cả giải thích về quy tắc được database bảo vệ. Chỉ mở `../solutions/11-constraints.sql` sau khi tự làm.
