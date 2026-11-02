-- TODO 1 (dễ): Trong BEGIN ... ROLLBACK, tạo TEMP TABLE lesson_product_draft.
-- Có id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY và name TEXT NOT NULL.
-- Đếm dòng ngay sau CREATE; giải thích vì sao chưa có dữ liệu.

-- TODO 2 (vừa): Dùng ALTER TABLE thêm price NUMERIC(14,2), stock INTEGER.
-- Thêm NOT NULL, CHECK không âm, DEFAULT stock = 0.
-- Giải thích vì sao DEFAULT, NOT NULL và CHECK không thay thế được nhau.

-- TODO 3 (khó): Thêm created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP.
-- Ghi một dòng chỉ truyền name và price, rồi đọc lại.
-- Giải thích id, stock và created_at được tạo từ đâu; rollback toàn bộ bài.
-- Vì sao không dùng CREATE TABLE IF NOT EXISTS để thêm những cột này?
