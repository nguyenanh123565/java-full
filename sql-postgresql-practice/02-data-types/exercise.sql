-- TODO 1 (dễ): Chọn kiểu cho id, name, email, price, stock và created_at.
-- Giải thích vì sao price không nên lưu bằng TEXT hoặc DOUBLE PRECISION.

-- TODO 2 (vừa): Tự viết query so sánh 7 chia 2 khi dùng INTEGER và NUMERIC.
-- Thử ép 123.456 sang NUMERIC(14,2); dự đoán trước khi chạy.
-- Giải thích kiểu của toán hạng ảnh hưởng kết quả như thế nào.

-- TODO 3 (khó): Trong BEGIN ... ROLLBACK, tạo bảng tạm lesson_type_exercise
-- có id BIGINT, name TEXT, price NUMERIC(14,2), stock INTEGER.
-- Thêm NOT NULL và CHECK phù hợp; ghi một dòng hợp lệ và đọc lại.
-- Chỉ viết giá trị sai như comment để dự đoán: stock âm, price là chữ, name NULL.
-- Giải thích trường hợp nào bị kiểu dữ liệu từ chối, trường hợp nào do constraint.
