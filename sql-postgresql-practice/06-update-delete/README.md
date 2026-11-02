# 06 — UPDATE và DELETE có phạm vi rõ ràng

## Khái niệm giải quyết vấn đề gì?

`UPDATE` thay đổi dòng đã có, `DELETE` bỏ dòng khỏi bảng. Backend dùng chúng để sửa giá, điều chỉnh tồn kho hoặc xóa một tài nguyên. Điều quan trọng là xác định chính xác tập dòng bị tác động và kiểm tra quy tắc nghiệp vụ trước khi thay đổi.

## SQL hoạt động như thế nào?

`WHERE` chọn tập dòng được thay đổi. Không có WHERE thì UPDATE/DELETE áp dụng cho tất cả dòng của bảng. Constraint vẫn được kiểm tra; thay đổi một bảng cha có thể bị FOREIGN KEY từ bảng con từ chối. `RETURNING` hiển thị giá trị sau UPDATE hoặc những dòng vừa DELETE.

Nên SELECT bằng cùng điều kiện trước để xem phạm vi. Sau đó mở transaction, thay đổi, xem kết quả và quyết định COMMIT hoặc ROLLBACK. Các demo ở đây chỉ sửa bản sao trong bảng tạm và luôn rollback. Bản sao được khai báo constraint rõ ràng: `CREATE TABLE AS SELECT` không tự sao chép đầy đủ constraint từ bảng nguồn.

## Ví dụ

```sql
UPDATE lesson_update_delete
SET stock = stock + 2
WHERE id = 1
RETURNING id, stock;
```

Đoán stock nếu ban đầu là 18. `SET stock = stock + 2` đọc giá trị cũ của từng dòng rồi ghi giá trị mới, không gán cùng một giá trị hằng cho mọi sản phẩm.

## Lỗi người mới hay mắc

- Quên WHERE, hoặc dùng điều kiện rộng hơn dự định.
- UPDATE bằng tên không UNIQUE và vô tình sửa nhiều dòng.
- Nhầm DELETE xóa dòng với DROP TABLE xóa cấu trúc bảng.
- Nghĩ DELETE sản phẩm luôn thành công dù order_items đang tham chiếu nó.
- Dùng ROLLBACK sau khi đã COMMIT và nghĩ có thể lấy lại dữ liệu.

## Câu hỏi kiểm tra hiểu biết

1. UPDATE không WHERE tác động bao nhiêu dòng?
2. Vì sao sửa theo PRIMARY KEY dễ xác định đúng một tài nguyên API?
3. RETURNING của UPDATE và DELETE cho biết những dòng nào?
4. ROLLBACK có thể hoàn tác một transaction đã COMMIT không?
5. Vì sao có thể xóa dòng trên bảng tạm bài này nhưng xóa cùng sản phẩm ở public lại bị FOREIGN KEY chặn?

## Ba bài tập từ dễ đến khó

1. Tạo bản sao tạm của ID, tên, giá, stock sản phẩm; kiểm tra riêng ID 1.
2. Tăng giá chỉ sản phẩm ID 1, xem RETURNING và kiểm tra ID 2 không đổi; giải thích phạm vi WHERE.
3. Xóa những dòng hết hàng trên bảng tạm, so sánh trước/sau rồi rollback; giải thích rủi ro nếu bỏ WHERE và khác biệt với DROP.

Đối chiếu riêng tại `../solutions/06-update-delete.sql`.
