-- 1. Không GROUP BY: toàn bộ products là một nhóm.
SELECT COUNT(*) AS product_count,
       MIN(price) AS min_price,
       MAX(price) AS max_price,
       AVG(price) AS average_price
FROM products;

-- 2. Mỗi dòng JOIN là item, COUNT DISTINCT tránh đếm lặp order.
SELECT COUNT(DISTINCT o.id) AS order_count,
       COALESCE(SUM(oi.quantity), 0) AS units_sold,
       COALESCE(SUM(oi.quantity * oi.price), 0) AS revenue
FROM orders AS o
JOIN order_items AS oi ON oi.order_id = o.id
WHERE o.status IN ('paid', 'shipped');
-- Chỉ hai trạng thái này được công nhận doanh thu trong bài; cancelled bị loại rõ ràng.
-- Giá item là giá lịch sử. SUM(o.total) sẽ cộng lặp tổng của order có nhiều items.

-- 3. Có 2 dòng giữ chỗ, 0 order thật, SUM = NULL, COALESCE = 0.
SELECT COUNT(*) AS joined_rows,
       COUNT(o.id) AS real_orders,
       SUM(o.total) AS raw_total,
       COALESCE(SUM(o.total), 0) AS total_for_api
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id
WHERE u.id IN (11, 12);
