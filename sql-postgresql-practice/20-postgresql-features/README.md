# Một số đặc trưng PostgreSQL

## Khái niệm giải quyết vấn đề gì?
Dùng các kiểu và cú pháp phù hợp với backend: ID tự cấp, kết quả ghi dữ liệu, tiền, thời gian và thuộc tính linh hoạt.

## SQL hoạt động như thế nào?
- IDENTITY gắn column với sequence; ALWAYS kiểm soát ID nhập tay hơn BY DEFAULT.
- SEQUENCE cấp số bằng nextval; không hứa liên tục vì rollback/concurrency.
- RETURNING trả row thực sự INSERT/UPDATE/DELETE, tránh query đoán lại ID.
- BOOLEAN có true/false; có NULL nếu column cho phép.
- TIMESTAMP không chứa timezone; TIMESTAMPTZ biểu diễn thời điểm, hiển thị theo timezone session, không giữ tên timezone gốc.
- NUMERIC(p,s) lưu số thập phân chính xác trong phạm vi; scale có thể làm tròn input.
- JSONB giữ dữ liệu JSON có cấu trúc; -> trả JSON, ->> trả text. Field thiếu trả SQL NULL.

## Ví dụ
```sql
SELECT '{"brand":"Acme","warrantyMonths":24}'::jsonb ->> 'brand' AS brand;
```

## Lỗi người mới hay mắc
- Dùng float/double cho tiền khi cần tính chính xác.
- Nghĩ TIMESTAMPTZ nhớ timezone gốc hoặc TIMESTAMP tự chuyển múi giờ.
- Nhầm -> và ->>; cast text JSON sai kiểu gây lỗi.
- Thay quan hệ/FK quan trọng bằng JSONB cho mọi dữ liệu.

## Câu hỏi kiểm tra hiểu biết
1. ALWAYS khác BY DEFAULT khi INSERT id thế nào?
2. Vì sao rollback vẫn có gap ID?
3. TIMESTAMP và TIMESTAMPTZ phù hợp với lịch địa phương/thời điểm ở đâu?
4. NUMERIC(14,2) nhận 1.235 sẽ lưu thế nào?
5. Thiếu key JSON trả gì khi dùng ->>?

## Ba bài tập từ dễ đến khó
1. Dễ: tạo bảng tạm có IDENTITY/BOOLEAN/NUMERIC(14,2), INSERT bỏ id rồi RETURNING; thử 1.235 và giải thích kết quả.
2. Vừa: so TIMESTAMP 2026-03-01 09:00 với TIMESTAMPTZ 2026-03-01 09:00+07 khi đổi session timezone UTC và Asia/Ho_Chi_Minh trong transaction; giải thích cái nào đổi hiển thị.
3. Khó: tạo bảng tạm snapshot ID products có PK, rồi bảng tạm metadata JSONB có FK tới snapshot; đọc brand/warrantyMonths, lọc warranty >=24, kiểm tra field thiếu IS NULL. Giải thích ->/->>, cast và vì sao không bỏ FK (TEMP không được FK tới bảng permanent).

Đọc demo, ghi dự đoán trước khi chạy. Tự làm `exercise.sql`; chỉ mở
`../solutions/20-postgresql-features.sql` sau khi đã thử và viết giải thích.
