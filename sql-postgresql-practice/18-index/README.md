# Index và quan sát kế hoạch thực thi

## Khái niệm giải quyết vấn đề gì?
Giảm lượng dữ liệu phải đọc khi truy vấn chọn một phần nhỏ bảng; hiểu chi phí lưu trữ và cập nhật của index.

## SQL hoạt động như thế nào?
- PostgreSQL planner chọn kế hoạch dựa trên thống kê và ước lượng chi phí, không chỉ vì index tồn tại.
- B-tree phù hợp với equality/range và một số ORDER BY; index (category_id, price) hữu ích cho category equality rồi price range.
- PK/UNIQUE đã tạo index; FK không tự tạo index ở cột phía con.
- EXPLAIN chỉ xem plan; EXPLAIN ANALYZE thực thi statement, kể cả DML.
- ANALYZE cập nhật thống kê; cost không phải milliseconds. Đọc estimated rows so với actual rows, loops và buffers.

## Ví dụ
```sql
EXPLAIN (ANALYZE, BUFFERS) SELECT * FROM products WHERE category_id = 1 AND price >= 5000000;
```

## Lỗi người mới hay mắc
- Đánh giá index trên 25 dòng rồi kết luận không cần index.
- Cho rằng mọi query phải dùng index hoặc index luôn nhanh hơn.
- So sánh một lần chạy lạnh và một lần chạy nóng rồi chỉ nhìn thời gian.
- Chạy EXPLAIN ANALYZE UPDATE/DELETE mà quên nó thực sự đổi dữ liệu.

## Câu hỏi kiểm tra hiểu biết
1. Vì sao Seq Scan hợp lý khi lấy gần toàn bảng?
2. EXPLAIN khác EXPLAIN ANALYZE ở đâu?
3. ANALYZE bảng khác ANALYZE trong EXPLAIN thế nào?
4. Index làm INSERT/UPDATE tốn thêm gì?
5. Vì sao index (category_id, price) hữu ích cho bộ lọc hai cột?

## Ba bài tập từ dễ đến khó
1. Dễ: ghi plan của query products category_id=1 AND price>=5000000 trên seed nhỏ; giải thích vì sao có thể Seq Scan dù index tồn tại.
2. Vừa: dùng generate_series như demo để tạo 200000 dòng trong bảng tạm; ghi EXPLAIN/EXPLAIN ANALYZE trước và sau index (category_id, price), cùng estimated/actual rows và buffers.
3. Khó: so query chọn rất ít dòng với query chọn gần toàn bảng; chạy vài lần, giải thích selectivity, cache, chi phí ghi và vì sao không ép planner tắt Seq Scan.

Đọc demo, ghi dự đoán trước khi chạy. Tự làm `exercise.sql`; chỉ mở
`../solutions/18-index.sql` sau khi đã thử và viết giải thích.
