BEGIN;
CREATE TEMP TABLE lesson_primary_key (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL
) ON COMMIT DROP;
-- PK không tự sinh ID: ví dụ chủ động cung cấp hai ID khác nhau.
INSERT INTO lesson_primary_key (id, name) VALUES (1, 'An'), (3, 'Bình');
SELECT id, name FROM lesson_primary_key ORDER BY id;
-- Không chạy lỗi: INSERT INTO lesson_primary_key VALUES (1, 'Trùng ID');

CREATE TEMP TABLE lesson_cart_key (
    user_id BIGINT,
    product_id BIGINT,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    PRIMARY KEY (user_id, product_id)
) ON COMMIT DROP;
-- Dự đoán: từng cột lặp nhưng tổ hợp có trùng không?
INSERT INTO lesson_cart_key (user_id, product_id, quantity)
VALUES (1, 1, 1), (1, 2, 1), (2, 1, 2);
SELECT * FROM lesson_cart_key ORDER BY user_id, product_id;
ROLLBACK;
