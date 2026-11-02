-- Dự đoán: có bao nhiêu dòng hợp lệ và quantity nhỏ nhất được chấp nhận?
-- Chạy trong database sql_postgresql_practice sau schema.sql và seed.sql.
BEGIN;

CREATE TEMP TABLE constraint_demo (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email text UNIQUE NOT NULL,
    quantity integer NOT NULL CHECK (quantity > 0)
) ON COMMIT DROP;

INSERT INTO constraint_demo (email, quantity)
VALUES ('demo-a@example.test', 1), ('demo-b@example.test', 3);

SELECT id, email, quantity
FROM constraint_demo
ORDER BY id;

-- Chỉ bỏ comment và chạy từng lệnh riêng nếu muốn quan sát lỗi:
-- INSERT INTO constraint_demo (email, quantity) VALUES ('demo-a@example.test', 2);
-- INSERT INTO constraint_demo (email, quantity) VALUES ('new@example.test', 0);
-- INSERT INTO constraint_demo (email, quantity) VALUES (NULL, 1);
-- Sau lỗi trong transaction hãy ROLLBACK trước khi thử tiếp.

ROLLBACK;
