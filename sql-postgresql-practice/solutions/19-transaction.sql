-- Bài 1: mẫu chạy lại được, kết thúc ROLLBACK; bản COMMIT tại bài học/commit_order.sql.

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

-- Bài 2: thiếu kho được phát hiện dưới lock; block con phục hồi rồi ngoài cùng rollback.
BEGIN;
SELECT id, stock FROM products WHERE id = 1 FOR UPDATE;
DO $$
BEGIN
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM products WHERE id = 1 AND stock >= 999) THEN
            RAISE EXCEPTION 'Không đủ tồn kho';
        END IF;
        RAISE EXCEPTION 'Demo yêu cầu seed chuẩn có stock < 999';
    EXCEPTION WHEN raise_exception THEN
        RAISE NOTICE 'Bài 2: lỗi dự kiến: %, không tạo order/items', SQLERRM;
    END;
END $$;
ROLLBACK;

-- Bài 3: block con là subtransaction; CHECK error tự rollback cả order vừa tạo.
BEGIN;
DO $$
DECLARE created_order_id BIGINT;
BEGIN
    BEGIN
        INSERT INTO orders (user_id, total, status) VALUES (1, 7500000, 'pending')
        RETURNING id INTO created_order_id;
        INSERT INTO order_items (order_id, product_id, quantity, price)
        VALUES (created_order_id, 1, 0, 7500000);
    EXCEPTION WHEN check_violation THEN
        RAISE NOTICE 'Bài 3: CHECK lỗi, block con đã rollback: %', SQLERRM;
    END;
END $$;
ROLLBACK;
-- Để thấy aborted transaction ở SQL thông thường, chạy rollback_failure.sql riêng.
-- Hai session: A BEGIN + SELECT ... FOR UPDATE trên product1; B chạy tương tự.
-- B chờ A COMMIT/ROLLBACK; sau đó phải kiểm tra stock lại. Khóa nhiều product theo id tăng.
