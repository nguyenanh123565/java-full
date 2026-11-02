# 16 — GROUP BY và HAVING: thống kê theo từng nhóm

## Khái niệm giải quyết vấn đề gì?

Một tổng chung không trả lời “mỗi user đã đặt bao nhiêu đơn?”, “doanh thu mỗi category là bao nhiêu?” hoặc “category nào bán ít nhất ba đơn vị?”. GROUP BY chia dữ liệu thành nhóm; HAVING chọn nhóm theo kết quả tổng hợp.

## SQL hoạt động như thế nào?

Thứ tự logic cơ bản là `FROM/JOIN → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT`. WHERE loại dòng trước khi nhóm; HAVING loại nhóm sau khi aggregate đã được tính. Kế hoạch vật lý có thể khác thứ tự viết vì PostgreSQL tối ưu việc thực thi.

Nhóm theo id định danh, thêm name để dễ đọc. Nhóm chỉ theo name có thể gộp hai người cùng tên. Các cột SELECT không được tổng hợp thường phải thuộc GROUP BY; PostgreSQL có ngoại lệ khi chúng phụ thuộc vào primary key của bảng gốc. Trong bài học dùng cả id và name để ý định rõ ràng.

JOIN một–nhiều có thể làm số dòng tăng trước GROUP BY. Nếu cần báo cáo hai loại tổng, hãy tổng hợp từng nhánh trước khi JOIN hoặc kiểm tra kỹ đơn vị mỗi dòng; `SUM(DISTINCT total)` không phải cách sửa chung vì hai đơn hợp lệ có thể có cùng tổng tiền.

## Ví dụ

```sql
SELECT u.id, u.name, COUNT(o.id) AS order_count
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id
GROUP BY u.id, u.name
HAVING COUNT(o.id) >= 2
ORDER BY u.id;
```

Mỗi dòng là một user có ít nhất hai orders. Bỏ HAVING để nhìn thấy cả user chưa có order với count = 0.

## Lỗi người mới hay mắc

- Đặt `COUNT(...)` trong WHERE thay cho HAVING.
- Chọn cột không có ý nghĩa duy nhất trong nhóm.
- Lọc orders ở WHERE sau LEFT JOIN, làm mất user có 0 order phù hợp.
- SUM orders.total sau JOIN items hoặc dùng SUM DISTINCT để che lỗi nhân dòng.
- Nhóm theo tên hiển thị thay vì id của đối tượng.

## Câu hỏi kiểm tra hiểu biết

1. WHERE và HAVING nhận đầu vào ở giai đoạn nào?
2. Nếu hai users cùng name, GROUP BY name có thể gây lỗi nghiệp vụ gì?
3. Vì sao COUNT(o.id) phù hợp với báo cáo giữ cả user chưa mua?
4. Vì sao SUM(DISTINCT o.total) có thể bỏ mất doanh thu hợp lệ?
5. Muốn giữ category chưa bán nhưng chỉ tính đơn paid/shipped, cần xử lý điều kiện ở đâu?

## Bài tập

Làm ba TODO trong `exercise.sql`: nhóm theo category, báo cáo mọi user và lọc nhóm theo doanh thu. Bài khó yêu cầu loại cancelled mà vẫn giữ nhóm không có giao dịch. Lời giải: `../solutions/16-group-by-having.sql`.
