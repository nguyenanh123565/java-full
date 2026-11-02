# 03 — CREATE TABLE và cấu trúc dữ liệu

## Khái niệm giải quyết vấn đề gì?

`CREATE TABLE` khai báo hình dạng dữ liệu trước khi lưu: tên cột, kiểu, giá trị mặc định và constraint. Bảng có cấu trúc tốt ngăn các dòng vô nghĩa như sản phẩm không có tên hoặc tồn kho âm. Đây là DDL: SQL định nghĩa cấu trúc, khác DML như `INSERT` thay đổi dữ liệu.

## SQL hoạt động như thế nào?

PostgreSQL lưu định nghĩa bảng trong catalog. Sau khi tạo, bảng vẫn rỗng; `DEFAULT` chỉ dùng khi ghi dòng và bỏ qua cột đó hoặc dùng từ khóa `DEFAULT`. `ALTER TABLE` thay đổi cấu trúc đã tồn tại. `IF NOT EXISTS` chỉ tránh lỗi khi tên đã tồn tại, không bảo đảm bảng cũ có cấu trúc mong muốn.

Bài này dùng `TEMP TABLE` trong transaction. Bảng tạm thuộc session hiện tại, không sửa năm bảng `public`. `ON COMMIT DROP` yêu cầu bỏ bảng khi commit; rollback transaction tạo bảng cũng bỏ bảng vừa tạo. Đây là cách thử DDL lặp lại an toàn.

## Ví dụ

```sql
CREATE TEMP TABLE lesson_product_draft (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0)
) ON COMMIT DROP;
```

Ví dụ nằm trong `BEGIN ... ROLLBACK` ở `demo.sql`. Đoán số dòng ngay sau `CREATE TABLE` và giá trị stock khi `INSERT` chỉ truyền name.

## Lỗi người mới hay mắc

- Nghĩ tạo bảng tự tạo dữ liệu mẫu.
- Quên constraint vì nghĩ ứng dụng Java luôn kiểm tra đủ.
- Nhầm `DEFAULT` với `NOT NULL`: truyền rõ `NULL` không được thay bằng default.
- Dùng `CREATE TABLE IF NOT EXISTS` như cách tự nâng cấp schema.
- Chạy `DROP TABLE public.products` để thử bài và làm mất dữ liệu chung.

## Câu hỏi kiểm tra hiểu biết

1. CREATE TABLE tạo cấu trúc hay tạo dữ liệu?
2. DEFAULT có áp dụng nếu INSERT truyền rõ NULL không?
3. Một bảng tạm khác bảng public về phạm vi sống như thế nào?
4. Vì sao cần CHECK stock không âm dù stock đã là INTEGER?

## Ba bài tập từ dễ đến khó

1. Tạo bảng tạm có ID và tên bắt buộc; giải thích vì sao chưa có dòng.
2. Thêm price và stock có giới hạn hợp lệ, đặt default stock bằng 0; phân biệt kiểu, default và constraint.
3. Thêm created_at mặc định hiện tại, ghi và đọc một sản phẩm; giải thích cột nào database tự điền rồi rollback.

Đối chiếu riêng tại `../solutions/03-create-table.sql`.
