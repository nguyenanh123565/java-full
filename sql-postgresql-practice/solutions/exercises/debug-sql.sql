-- Chỉ đối chiếu sau khi tự sửa sáu query trong exercise.sql.
-- Bài 1: orders.user_id tham chiếu users.id; id đơn không phải id người mua.
SELECT o.id AS order_id, u.id AS user_id, u.name
FROM orders o JOIN users u ON u.id = o.user_id ORDER BY o.id;

-- Bài 2: So sánh bằng NULL là UNKNOWN; IS NULL kiểm tra giá trị NULL.
SELECT p.id, p.name FROM products p
LEFT JOIN order_items oi ON oi.product_id = p.id
WHERE oi.id IS NULL ORDER BY p.id;

-- Bài 3: Bỏ order.id vì yêu cầu một dòng mỗi user, không một dòng mỗi đơn.
SELECT user_id, COUNT(*) AS order_count FROM orders GROUP BY user_id ORDER BY user_id;

-- Bài 4: WHERE thu hẹp đúng sản phẩm và tránh tồn âm; RETURNING cho biết dòng đã đổi.
-- 0 dòng có thể là hết hàng hoặc id không tồn tại; backend phải xử lý kết quả đó.
BEGIN;
SELECT id, stock FROM products WHERE id = 1;
UPDATE products SET stock = stock - 1
WHERE id = 1 AND stock >= 1 RETURNING id, stock;
ROLLBACK;

-- Bài 5: Chọn một đơn cancelled và khóa dòng cha trong transaction.
-- Bảng tạm giữ cùng một id cho hai lệnh DELETE; tự xóa khi transaction kết thúc.
-- FK order_items.order_id dùng CASCADE: xóa cha trực tiếp cũng xóa các dòng hàng.
-- Ở đây xóa con trước, cha sau để nhìn rõ từng bước. Không có cancelled: 0 dòng.
BEGIN;
CREATE TEMP TABLE debug_order_target (id bigint PRIMARY KEY) ON COMMIT DROP;
INSERT INTO debug_order_target (id)
SELECT id FROM orders WHERE status = 'cancelled' ORDER BY id LIMIT 1 FOR UPDATE;
SELECT o.id, o.status, o.total FROM orders o
JOIN debug_order_target t ON t.id = o.id;
DELETE FROM order_items oi USING debug_order_target t
WHERE oi.order_id = t.id RETURNING oi.id, oi.order_id;
DELETE FROM orders o USING debug_order_target t
WHERE o.id = t.id AND o.status = 'cancelled' RETURNING o.id, o.status;
ROLLBACK;

-- Bài 6: Một dòng đầu vào là một order; chưa nối dòng hàng nên total không lặp.
-- Không dùng SUM(DISTINCT total), vì hai đơn thật có thể có cùng total.
SELECT u.id, u.name, COALESCE(SUM(o.total), 0) AS total_order_value
FROM users u LEFT JOIN orders o ON o.user_id = u.id
GROUP BY u.id, u.name ORDER BY u.id;
