# 07 — WHERE và điều kiện lọc

## Khái niệm giải quyết vấn đề gì?

`WHERE` chọn những dòng đáp ứng điều kiện. API lọc sản phẩm theo tồn kho, danh mục và khoảng giá cần diễn đạt chính xác điều kiện nghiệp vụ thay vì lấy tất cả về Java rồi tự lọc.

## SQL hoạt động như thế nào?

Với mỗi dòng, WHERE kiểm tra biểu thức logic; chỉ giá trị TRUE được giữ. FALSE và UNKNOWN đều bị loại. So sánh với NULL cho UNKNOWN; dùng `IS NULL` hoặc `IS NOT NULL` khi kiểm tra thiếu giá trị. Các cột bảng chính đều NOT NULL, nhưng NULL có thể xuất hiện trong dữ liệu tạm hoặc kết quả LEFT JOIN ở bài sau.

`BETWEEN a AND b` bao gồm cả hai đầu mút. `IN (...)` kiểm tra thuộc tập. `AND` có độ ưu tiên cao hơn `OR`; dùng ngoặc để ý định rõ ràng. `LIKE` dùng `%` cho chuỗi bất kỳ, `_` cho một ký tự; PostgreSQL có `ILIKE` cho so khớp không phân biệt hoa/thường.

## Ví dụ

```sql
SELECT id, name, price, stock
FROM public.products
WHERE stock > 0 AND price BETWEEN 1000000 AND 5000000
ORDER BY id;
```

Đây là hai điều kiện đồng thời. Query `category_id = 1 OR category_id = 2 AND stock > 0` lại áp dụng điều kiện stock chỉ cho nhánh category 2; ngoặc sẽ thay đổi ý nghĩa.

## Lỗi người mới hay mắc

- Viết `column = NULL` rồi không hiểu vì sao không có dòng.
- Thiếu ngoặc khi trộn AND và OR.
- Nghĩ BETWEEN không lấy hai đầu mút.
- Dùng LIKE với chuỗi không có `%` dù muốn tìm một phần tên.
- Lọc thời gian bằng BETWEEN đến đúng 00:00 của ngày cuối và bỏ sót phần còn lại của ngày.

## Câu hỏi kiểm tra hiểu biết

1. WHERE giữ dòng có điều kiện UNKNOWN không?
2. Vì sao `NULL = NULL` không trả TRUE?
3. AND và OR được nhóm thế nào nếu không có ngoặc?
4. Giá đúng 1000000 hoặc 5000000 có nằm trong BETWEEN không?
5. `LIKE '%robot%'` khác `LIKE 'robot'` thế nào?

## Ba bài tập từ dễ đến khó

1. Tìm sản phẩm stock lớn hơn 0; giải thích vì sao stock bằng 0 bị loại.
2. Tìm sản phẩm giá từ 1 đến 5 triệu còn hàng; giải thích đầu mút của BETWEEN.
3. Lọc category 1 hoặc 2 còn hàng và thử dữ liệu nullable tự tạo; giải thích ngoặc và IS NULL.

Đối chiếu riêng tại `../solutions/07-where-filtering.sql`.
