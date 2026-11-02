BEGIN;
-- 1. PRIMARY KEY bảo vệ duy nhất + không NULL, không tự tạo số.
CREATE TEMP TABLE lesson_pk_exercise (id BIGINT PRIMARY KEY, name TEXT NOT NULL)
ON COMMIT DROP;
INSERT INTO lesson_pk_exercise (id, name) VALUES (1, 'An'), (3, 'Bình');
SELECT id, name FROM lesson_pk_exercise ORDER BY id;

-- 2. Giữ lỗi dưới dạng comment: không làm hỏng transaction đang chạy.
-- INSERT INTO lesson_pk_exercise (id, name) VALUES (1, 'Trùng'); -- vi phạm UNIQUE của PK
-- INSERT INTO lesson_pk_exercise (id, name) VALUES (NULL, 'Thiếu'); -- vi phạm NOT NULL của PK

-- 3. PK ghép bảo vệ toàn bộ tổ hợp, không yêu cầu từng thành phần duy nhất.
CREATE TEMP TABLE lesson_cart_exercise (
    user_id BIGINT,
    product_id BIGINT,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    PRIMARY KEY (user_id, product_id)
) ON COMMIT DROP;
INSERT INTO lesson_cart_exercise (user_id, product_id, quantity)
VALUES (1, 1, 1), (1, 2, 1), (2, 1, 2);
SELECT * FROM lesson_cart_exercise ORDER BY user_id, product_id;
-- Hai dòng order_items có id khác nhau vẫn có thể cùng order/product nếu thiếu UNIQUE.
ROLLBACK;
