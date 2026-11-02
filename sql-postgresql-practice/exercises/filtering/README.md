# Luyện tập lọc dữ liệu

## Khái niệm giải quyết vấn đề gì?

Lọc chọn những dòng đáp ứng một yêu cầu: sản phẩm còn hàng, khoảng giá, từ khóa hoặc đơn hàng trong một tháng. Viết điều kiện theo nghiệp vụ trước, sau đó diễn đạt bằng SQL.

## SQL hoạt động như thế nào?

`WHERE` giữ dòng khi biểu thức cho kết quả `TRUE`; `FALSE` và `UNKNOWN` đều bị loại. `BETWEEN` gồm hai đầu mút. `AND` được ưu tiên trước `OR`; ngoặc thể hiện rõ nhóm điều kiện. `ILIKE` của PostgreSQL so khớp chuỗi không phân biệt chữ hoa/thường; `%` là chuỗi bất kỳ. Khoảng thời gian dạng `>= đầu AND < cuối` tránh bỏ sót phần giây cuối ngày.

## Ví dụ và cách chạy

Seed có đơn hàng trong tháng 01–03/2026. Tháng 01 được hiểu theo múi giờ Việt Nam:

```sql
SELECT id, created_at FROM orders
WHERE created_at >= TIMESTAMPTZ '2026-01-01 00:00:00+07'
  AND created_at < TIMESTAMPTZ '2026-02-01 00:00:00+07'
ORDER BY created_at, id;
```

Sau khi nạp database, chạy `demo.sql` trong SQL editor hoặc dùng psql từ gốc workspace:

```powershell
psql -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f exercises/filtering/demo.sql
```

## Lỗi người mới hay mắc

- Quên ngoặc khi kết hợp `AND` và `OR`.
- Dùng `BETWEEN` cho tháng với mốc cuối là `23:59:59`, bỏ sót phần giây.
- So sánh `NULL` bằng `=`; phải hiểu `IS NULL` khi gặp dữ liệu nullable hoặc LEFT JOIN.
- Dùng thời gian hiện tại cho seed cố định rồi nghĩ query hỏng khi trả về rỗng.
- Nhầm `ILIKE '%an%'` là so khớp toàn bộ tên.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao `WHERE` không giữ các dòng có điều kiện `UNKNOWN`?
2. Giá đúng 1.000.000 có thuộc `BETWEEN 1000000 AND 5000000` không?
3. `A AND B OR C` khác `A AND (B OR C)` thế nào?
4. Vì sao dùng mốc đầu tháng sau và dấu `<` thuận tiện hơn mốc cuối tháng?
5. Tìm chuỗi bằng `%` có phải tìm giá trị chính xác không?

## Bài tập

Hoàn thành năm TODO: tồn kho, khoảng giá, nhóm điều kiện, từ khóa và tháng 01/2026. Ghi ít nhất một dòng đáng lẽ được giữ hoặc bị loại để kiểm tra lý luận. Solutions: `../../solutions/exercises/filtering.sql`.
