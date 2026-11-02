# 04 — INSERT dữ liệu

## Khái niệm giải quyết vấn đề gì?

`INSERT` thêm dòng mới vào bảng. Trong backend, thao tác tạo user hoặc sản phẩm thường dẫn tới INSERT. Phải xác định rõ cột nào người gọi cung cấp, cột nào database tự tạo và điều kiện để dữ liệu hợp lệ.

## SQL hoạt động như thế nào?

PostgreSQL ánh xạ từng giá trị theo danh sách cột, chuyển kiểu, điền default/identity cho cột bị bỏ qua rồi kiểm tra constraint. Nếu một dòng vi phạm constraint, câu lệnh nhiều dòng thất bại toàn bộ; không tự bỏ qua riêng dòng sai. `RETURNING` trả giá trị vừa ghi trong cùng câu lệnh, hữu ích khi Java cần ID tạo mới.

Luôn ghi danh sách cột: `INSERT INTO table (name, price) VALUES (...)`. Thứ tự giá trị phải khớp danh sách này. Bỏ cột khác với truyền `NULL`; cột `NOT NULL` không có default phải được cung cấp.

Bài dùng bảng tạm và rollback để chạy lại nhiều lần mà không tạo dữ liệu thừa trong database học chung.

## Ví dụ

```sql
INSERT INTO lesson_insert_products (name, price, stock)
VALUES ('Robot demo', 7500000, 4)
RETURNING id, name, stock;
```

Đoán ID được lấy từ đâu và query trả bao nhiêu dòng. Không dùng `MAX(id)` để đoán ID vừa tạo: những kết nối khác có thể ghi dữ liệu đồng thời.

## Lỗi người mới hay mắc

- Bỏ danh sách cột và phụ thuộc thứ tự cột của bảng.
- Truyền số trong dấu nháy mà không hiểu phép chuyển kiểu ngầm.
- Nghĩ truyền NULL sẽ dùng DEFAULT.
- Nghĩ một INSERT nhiều dòng sẽ giữ lại các dòng hợp lệ khi có dòng sai.
- Tự điền ID vào cột `GENERATED ALWAYS` trong thao tác thông thường.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao nên ghi danh sách cột rõ ràng?
2. Cột bị bỏ qua sẽ nhận giá trị nào nếu có DEFAULT? Nếu không có?
3. RETURNING khác một SELECT sau INSERT về cách lấy ID như thế nào?
4. Nếu dòng thứ hai trong INSERT ba dòng vi phạm CHECK, có dòng nào được ghi bởi câu lệnh đó không?

## Ba bài tập từ dễ đến khó

1. Tạo bảng tạm cho sản phẩm và thêm một sản phẩm hợp lệ.
2. Thêm hai sản phẩm trong một câu lệnh, một sản phẩm stock bằng 0; giải thích hết hàng khác không biết tồn kho.
3. Dùng RETURNING lấy ID và giá; phân tích một INSERT nhiều dòng có dữ liệu sai bằng comment rồi rollback.

Đối chiếu riêng tại `../solutions/04-insert.sql`.
