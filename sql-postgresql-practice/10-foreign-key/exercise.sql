-- TODO 1 (dễ): Trong BEGIN ... ROLLBACK, tạo TEMP TABLE lesson_fk_parent
-- có id PRIMARY KEY, name NOT NULL; tạo lesson_fk_child có id, name, category_id.
-- category_id NOT NULL REFERENCES lesson_fk_parent(id) ON DELETE RESTRICT.
-- Ghi category 1 trước, rồi product thuộc category 1; giải thích thứ tự này.

-- TODO 2 (vừa): Chỉ viết bằng comment INSERT product có category_id = 999 chưa tồn tại.
-- Dự đoán lỗi và giải thích vì sao cùng kiểu BIGINT vẫn không đủ.
-- FK có tự tạo category 999 hoặc tự SELECT tên category không? Vì sao?

-- TODO 3 (khó): Dự đoán bằng comment việc DELETE category 1 khi còn product tham chiếu.
-- Sau đó xóa product trước, xóa category sau trên bảng tạm và xem RETURNING.
-- Giải thích RESTRICT khác CASCADE; vì sao FK không bắt buộc cha phải có con?
-- ROLLBACK toàn bộ; liên hệ rủi ro cascade khi xóa user có lịch sử orders.
