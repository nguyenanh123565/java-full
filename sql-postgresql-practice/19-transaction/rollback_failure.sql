-- CỐ TÌNH LỖI. Chạy cả file bằng psql -v ON_ERROR_STOP=0 để đi tới ROLLBACK,
-- hoặc chạy từng block trong cùng một session của pgAdmin.
-- PostgreSQL báo CHECK violation rồi current transaction is aborted: đó là mục tiêu.
BEGIN;
CREATE TEMP TABLE lesson19_failure_context (order_id BIGINT) ON COMMIT DROP;
WITH new_order AS (
    INSERT INTO orders (user_id, total, status) VALUES (1, 7500000, 'pending') RETURNING id
)
INSERT INTO lesson19_failure_context SELECT id FROM new_order;
INSERT INTO order_items (order_id, product_id, quantity, price)
SELECT order_id, 1, 0, 7500000 FROM lesson19_failure_context;
-- Câu này không chạy thành công vì transaction đã aborted.
UPDATE products SET stock = stock - 1 WHERE id = 1;
ROLLBACK;
-- order mới biến mất, kho giữ nguyên; sequence có thể đã tăng.
SELECT id, stock FROM products WHERE id = 1;
SELECT COUNT(*) AS order_count FROM orders;
