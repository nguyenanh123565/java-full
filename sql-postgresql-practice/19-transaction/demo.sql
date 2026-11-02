-- Demo chỉ quan sát thay đổi, ROLLBACK để giữ seed. Đoán stock trước/sau.

BEGIN;
CREATE TEMP TABLE lesson19_new_order (order_id BIGINT) ON COMMIT DROP;
-- Khóa sản phẩm trước khi đọc giá/kiểm tra tồn kho; người khác phải chờ.
SELECT id, price, stock FROM products WHERE id = 1 FOR UPDATE;
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM products WHERE id = 1 AND stock >= 2) THEN
        RAISE EXCEPTION 'Sản phẩm không tồn tại hoặc không đủ tồn kho';
    END IF;
END $$;

-- RETURNING lấy đúng ID vừa tạo; không dùng MAX(id) để đoán order của mình.
WITH new_order AS (
    INSERT INTO orders (user_id, total, status)
    SELECT 1, price * 2, 'pending' FROM products WHERE id = 1
    RETURNING id
)
INSERT INTO lesson19_new_order SELECT id FROM new_order;

INSERT INTO order_items (order_id, product_id, quantity, price)
SELECT context.order_id, p.id, 2, p.price
FROM lesson19_new_order context CROSS JOIN products p WHERE p.id = 1;

-- Validation đã thành công dưới row lock; giảm stock trong cùng transaction.
UPDATE products SET stock = stock - 2
WHERE id = 1 AND stock >= 2 RETURNING id, stock;
SELECT o.id, o.total, SUM(oi.quantity * oi.price) AS items_total
FROM orders o JOIN lesson19_new_order context ON context.order_id = o.id
JOIN order_items oi ON oi.order_id = o.id GROUP BY o.id, o.total;
ROLLBACK;
SELECT id, stock FROM products WHERE id = 1;
