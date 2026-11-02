# 01 — Database, schema và bảng

## Khái niệm giải quyết vấn đề gì?

Database lưu dữ liệu có cấu trúc và cung cấp cách đọc, thay đổi, ràng buộc dữ liệu. Một PostgreSQL server có thể chứa nhiều database. Trong một database, schema là không gian tên chứa bảng và các đối tượng khác; `public.users` nghĩa là bảng `users` thuộc schema `public`.

Workspace dùng một database `sql_postgresql_practice` xuyên suốt. Năm bảng mô tả người dùng, danh mục, sản phẩm, đơn hàng và các dòng hàng. Một dòng trong `order_items` mô tả một sản phẩm trong một đơn, không phải một đơn hoàn chỉnh.

## SQL hoạt động như thế nào?

Bạn kết nối đến một database trước khi gửi SQL. `SELECT` mô tả dữ liệu muốn lấy; PostgreSQL phân tích tên bảng/cột, kiểm tra quyền rồi chọn cách thực hiện. Database không tự đổi khi bạn ghi tên bảng. Dùng `public.products` giúp thấy rõ schema; chỉ ghi `products` thì tên được tìm theo `search_path`.

Bảng không có thứ tự mặc định. Mỗi dòng có cột; kiểu dữ liệu và constraint quyết định giá trị hợp lệ. Query đọc dữ liệu có thể trả về nhiều dòng, một dòng hoặc không có dòng.

## Ví dụ

```sql
SELECT current_database(), current_schema();
SELECT id, name FROM public.products ORDER BY id LIMIT 3;
```

Đoán hai query trên trả về gì trước khi mở `demo.sql`. Query thứ hai đọc bảng có sẵn, không tạo hay thay đổi sản phẩm.

## Lỗi người mới hay mắc

- Nhầm server, database và schema là cùng một thứ.
- Chạy `schema.sql` ở database mặc định `postgres`, rồi tìm bảng ở database luyện tập.
- Nghĩ tên bảng luôn tìm ở `public`, dù `search_path` có thể thay đổi.
- Nghĩ thứ tự dòng thấy hôm nay là thứ tự luôn được bảo đảm.
- Coi một dòng kết quả JOIN là một đối tượng nghiệp vụ hoàn chỉnh.

## Câu hỏi kiểm tra hiểu biết

1. Hai schema trong cùng database có thể cùng chứa bảng tên `users` không? Vì sao?
2. `current_database()` và `current_schema()` trả lời hai câu hỏi khác nhau như thế nào?
3. Vì sao cần `ORDER BY` khi muốn ba sản phẩm đầu theo ID?
4. Vì sao cần `orders` và `order_items` thay vì chỉ một bảng orders?

## Ba bài tập từ dễ đến khó

1. Kiểm tra database/schema đang kết nối; giải thích từng giá trị.
2. Đọc ba cột `id`, `name`, `email` của ba user đầu theo ID; giải thích bảng, dòng và cột của kết quả.
3. Đếm số dòng của cả năm bảng; giải thích vì sao số dòng `orders` và `order_items` không phải cùng một đại lượng.

Viết lời giải trong bản sao riêng của `exercise.sql`. Chỉ mở `../solutions/01-database-basics.sql` khi cần đối chiếu.
