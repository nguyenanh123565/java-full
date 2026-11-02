# 08 — ORDER BY, LIMIT và phân trang

## Khái niệm giải quyết vấn đề gì?

`ORDER BY` xác định thứ tự kết quả. `LIMIT` giới hạn số dòng; `OFFSET` bỏ qua một số dòng đầu. Chúng phục vụ màn hình danh sách và API phân trang, nơi người dùng cần xem sản phẩm theo giá hoặc lấy từng phần dữ liệu.

## SQL hoạt động như thế nào?

Sau lọc, ORDER BY mô tả thứ tự, OFFSET bỏ qua dòng rồi LIMIT lấy phần còn lại. PostgreSQL có thể dùng sort hoặc index để tạo thứ tự. Query không ORDER BY không bảo đảm dòng nào là "đầu tiên". Nếu nhiều dòng cùng giá, chỉ sắp theo giá vẫn để thứ tự giữa những dòng bằng giá chưa xác định; thêm ID duy nhất làm khóa phụ.

Trang 2 với cỡ trang 5 dùng OFFSET 5. OFFSET lớn có thể tốn công vì database vẫn phải tìm và bỏ qua các dòng trước đó. Phân trang theo mốc ID (`id > last_id`) là cách cơ bản tránh bỏ qua nhiều dòng, nhưng cần khóa sắp xếp và chiều so sánh nhất quán. Nếu dữ liệu thay đổi giữa các request, phân trang OFFSET có thể lặp hoặc bỏ sót dòng.

## Ví dụ

```sql
SELECT id, name, price FROM public.products
ORDER BY price DESC, id ASC
LIMIT 5 OFFSET 5;
```

Query lấy trang 2 của danh sách giá cao trước, ID tăng trong nhóm giá bằng nhau. `LIMIT` không có nghĩa database luôn chỉ đọc đúng 5 dòng.

## Lỗi người mới hay mắc

- Dùng LIMIT mà không ORDER BY và nghĩ phân trang ổn định.
- Không thêm khóa phụ duy nhất khi giá hoặc thời gian trùng.
- Nghĩ OFFSET là số trang, nên trang 2 dùng OFFSET 2.
- Trộn `ORDER BY price` với mốc `id > last_id` dù ID không cùng thứ tự giá.
- Dùng OFFSET rất lớn mà không đo kế hoạch thực thi.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao LIMIT 5 không xác định năm dòng nào nếu thiếu ORDER BY?
2. Vì sao ORDER BY price DESC, id ASC ổn định hơn chỉ price DESC?
3. Cỡ trang 10 thì trang 3 cần OFFSET bao nhiêu?
4. Vì sao query theo mốc ID phải ORDER BY ID?
5. Một INSERT giữa hai request có thể ảnh hưởng phân trang OFFSET thế nào?

## Ba bài tập từ dễ đến khó

1. Lấy năm sản phẩm còn hàng giá cao nhất, dùng ID làm khóa phụ; giải thích ties.
2. Lấy trang 2 cùng điều kiện và cỡ trang; giải thích công thức OFFSET.
3. Lấy năm sản phẩm tiếp sau ID 10 theo ID; so sánh với OFFSET và giới hạn của từng cách.

Đối chiếu riêng tại `../solutions/08-order-limit.sql`.
