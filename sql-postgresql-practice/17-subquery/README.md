# 17 — Subquery: dùng kết quả một query trong query khác

## Khái niệm giải quyết vấn đề gì?

Những câu hỏi như “sản phẩm đắt hơn mức trung bình”, “user chưa từng mua hàng” hoặc “top sản phẩm theo doanh thu” cần kết quả trung gian. Subquery giúp viết trực tiếp mối quan hệ giữa các bước, không cần lấy dữ liệu ra Java để ghép query thủ công.

## SQL hoạt động như thế nào?

- Scalar subquery trả một cột và tối đa một dòng; có thể dùng như một giá trị. Không có dòng cho giá trị NULL, nhiều hơn một dòng gây lỗi.
- `IN (SELECT ...)` kiểm tra thuộc tập giá trị.
- `EXISTS (SELECT ...)` chỉ hỏi có dòng thỏa điều kiện hay không. Correlated subquery tham chiếu cột của query ngoài, ví dụ `o.user_id = u.id`.
- Subquery trong FROM tạo bảng kết quả trung gian, cần alias. Có thể aggregate ở đây trước khi JOIN để tránh nhân tổng.

Đó là ý nghĩa logic, không phải cam kết PostgreSQL chạy query con tuần tự cho từng dòng. Optimizer có thể biến đổi thành JOIN hoặc kế hoạch khác. Dùng EXPLAIN ở bài 18 để quan sát.

## Ví dụ

```sql
SELECT id, name, price
FROM products
WHERE price > (SELECT AVG(price) FROM products)
ORDER BY price DESC, id;
```

AVG không GROUP BY trả một giá trị làm ngưỡng chung. Thay SELECT AVG(price) bằng SELECT price có thể trả nhiều dòng và khiến scalar subquery lỗi.

## Lỗi người mới hay mắc

- Dùng query nhiều dòng ở vị trí cần một giá trị.
- Quên điều kiện tương quan trong EXISTS, khiến mọi user cùng nhận một kết quả.
- Nghĩ EXISTS cần SELECT toàn bộ cột; `SELECT 1` diễn đạt đủ ý định.
- Dùng NOT IN mà không xét NULL: nếu tập con có NULL, các phép so sánh có thể thành UNKNOWN và bỏ kết quả mong đợi. NOT EXISTS thường dễ thể hiện truy vấn “không có”.
- Cho rằng subquery luôn chậm hơn JOIN mà chưa xem kế hoạch hoặc đo dữ liệu thật.

## Câu hỏi kiểm tra hiểu biết

1. Scalar subquery trả 0, 1 hoặc nhiều dòng thì chuyện gì xảy ra?
2. Điều gì làm một subquery trở thành correlated subquery?
3. Vì sao NOT EXISTS phù hợp để tìm user chưa có order?
4. NOT IN với tập có NULL khác với trực giác so sánh số như thế nào?
5. Vì sao tổng hợp items trước khi JOIN có thể tránh nhân tổng order?

## Bài tập

Hoàn thành ba TODO trong `exercise.sql`: ngưỡng trung bình chung, truy vấn không tồn tại và trung bình theo category. Chỉ mở `../solutions/17-subquery.sql` sau khi đã giải thích query của mình.
