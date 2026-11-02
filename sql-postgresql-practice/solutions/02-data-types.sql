-- 1. ID: BIGINT; name/email: TEXT; price: NUMERIC(14,2); stock: INTEGER;
-- created_at: TIMESTAMPTZ. Tiền cần số thập phân chính xác để tính toán.
-- TEXT sắp xếp như chuỗi; DOUBLE PRECISION có thể có sai số biểu diễn.

-- 2. Phép chia nguyên bỏ phần lẻ; ép NUMERIC trước khi chia giữ phần thập phân.
SELECT 7 / 2 AS integer_result, 7::NUMERIC / 2 AS numeric_result,
       123.456::NUMERIC(14,2) AS rounded_price;

-- 3. Kiểu, NOT NULL và CHECK giải quyết những yêu cầu khác nhau.
BEGIN;
CREATE TEMP TABLE lesson_type_exercise (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL CHECK (stock >= 0)
) ON COMMIT DROP;
INSERT INTO lesson_type_exercise (id, name, price, stock)
VALUES (1, 'Sản phẩm thử', 123.456, 2);
SELECT * FROM lesson_type_exercise;
-- stock = -1: INTEGER hợp lệ nhưng vi phạm CHECK.
-- price = 'abc': không thể chuyển sang NUMERIC.
-- name = NULL: vi phạm NOT NULL, không phải TEXT tự cấm NULL.
ROLLBACK;
