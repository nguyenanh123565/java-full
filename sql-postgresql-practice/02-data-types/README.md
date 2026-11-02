# 02 — Kiểu dữ liệu

## Khái niệm giải quyết vấn đề gì?

Kiểu dữ liệu diễn tả ý nghĩa của giá trị và giới hạn phép toán hợp lệ. ID dùng `BIGINT`, tồn kho dùng `INTEGER`, tiền dùng `NUMERIC(14,2)`, tên dùng `TEXT`, thời điểm tạo dùng `TIMESTAMPTZ`. Chọn đúng kiểu giúp database từ chối dữ liệu không phù hợp và tính toán đúng ý định.

`NUMERIC(14,2)` có tối đa 14 chữ số tổng cộng, trong đó 2 chữ số thập phân. Đây là kiểu thập phân chính xác, thích hợp cho số tiền. `REAL`/`DOUBLE PRECISION` biểu diễn gần đúng nên không dùng làm mặc định cho tiền. `TEXT` chứa chuỗi; không cần giả định tên chỉ có 50 ký tự khi chưa có yêu cầu nghiệp vụ.

## SQL hoạt động như thế nào?

Khi ghi dữ liệu, PostgreSQL chuyển giá trị sang kiểu của cột nếu có phép chuyển hợp lệ, kiểm tra giới hạn kiểu rồi kiểm tra constraint. Ép kiểu rõ ràng bằng `CAST(value AS type)` hoặc `value::type` giúp thấy ý định. Kiểu không thay thế constraint: `INTEGER` vẫn cho phép số âm, nên tồn kho cần thêm `CHECK (stock >= 0)`.

`NULL` biểu diễn thiếu/không biết giá trị, khác chuỗi rỗng và số 0. Các cột nghiệp vụ chính trong workspace là `NOT NULL`. `TIMESTAMPTZ` lưu một thời điểm; cách hiển thị phụ thuộc timezone của session.

## Ví dụ

```sql
SELECT 5 / 2 AS integer_division, 5::NUMERIC / 2 AS decimal_division;
SELECT 10.129::NUMERIC(14,2) AS rounded_price;
```

Đoán kết quả trước khi chạy. Vì sao chia hai số nguyên khác chia số thập phân? Vì sao giá bị làm tròn khi ép sang hai chữ số thập phân?

## Lỗi người mới hay mắc

- Lưu giá bằng `TEXT` rồi sắp xếp theo thứ tự chữ.
- Dùng số thực gần đúng để tính tiền mà không hiểu sai số.
- Nghĩ `NUMERIC(14,2)` cho phép 14 chữ số trước dấu thập phân.
- Nghĩ `INTEGER` tự cấm tồn kho âm.
- Nhầm `NULL`, `0` và `''` có cùng ý nghĩa.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao ID và giá bán có thể cùng là số nhưng nên dùng kiểu khác nhau?
2. `5 / 2` trả số nào, và đổi kiểu ở đâu để nhận phần thập phân?
3. `NUMERIC(14,2)` lưu được bao nhiêu chữ số phần nguyên?
4. Vì sao `TIMESTAMPTZ` hiển thị khác nhau ở hai timezone nhưng vẫn có thể là cùng thời điểm?
5. Một kiểu số nguyên có đủ để bảo vệ quy tắc tồn kho không âm không?

## Ba bài tập từ dễ đến khó

1. Đề xuất kiểu cho các cột e-commerce; giải thích lựa chọn cho giá và tồn kho.
2. So sánh chia nguyên với chia thập phân và làm tròn giá; dự đoán trước khi chạy.
3. Tạo bảng tạm kiểm tra kiểu và constraint, lưu một sản phẩm hợp lệ; mô tả riêng cách database từ chối dữ liệu sai.

Đối chiếu riêng tại `../solutions/02-data-types.sql`.
