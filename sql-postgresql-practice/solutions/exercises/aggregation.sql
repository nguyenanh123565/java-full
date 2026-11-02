-- Bài 1: COUNT(*) đếm mã sản phẩm; SUM(stock) đếm đơn vị đang tồn.
SELECT COUNT(*) AS product_count, MIN(price) AS min_price,
       MAX(price) AS max_price, AVG(price) AS average_price,
       SUM(stock) AS total_stock
FROM products;

-- Bài 2: COUNT(p.id) không đếm dòng NULL được LEFT JOIN bổ sung.
SELECT c.id, c.name, COUNT(p.id) AS product_count,
       COALESCE(SUM(p.stock), 0) AS total_stock
FROM categories c LEFT JOIN products p ON p.category_id = c.id
GROUP BY c.id, c.name ORDER BY c.id;

-- Bài 3: Lọc bảng phải trong ON để vẫn giữ user có 0 đơn hợp lệ.
-- Một dòng JOIN là một đơn, chưa JOIN dòng hàng nên total không bị nhân.
SELECT u.id, u.name, COUNT(o.id) AS order_count,
       COALESCE(SUM(o.total), 0) AS total_order_value
FROM users u
LEFT JOIN orders o ON o.user_id = u.id AND o.status <> 'cancelled'
GROUP BY u.id, u.name ORDER BY u.id;

-- Bài 4: WHERE lọc đơn; HAVING lọc nhóm user sau khi đếm.
SELECT u.id, u.name, COUNT(o.id) AS order_count, SUM(o.total) AS total_order_value
FROM users u JOIN orders o ON o.user_id = u.id
WHERE o.status <> 'cancelled'
GROUP BY u.id, u.name HAVING COUNT(o.id) >= 3 ORDER BY u.id;

-- Bài 5: Số lượng đặt khác số dòng hàng; tiền dùng giá đã lưu lúc đặt.
SELECT p.id AS product_id, p.name,
       SUM(oi.quantity) AS ordered_quantity,
       SUM(oi.quantity * oi.price) AS ordered_value
FROM products p
JOIN order_items oi ON oi.product_id = p.id
JOIN orders o ON o.id = oi.order_id
WHERE o.status <> 'cancelled'
GROUP BY p.id, p.name
ORDER BY ordered_quantity DESC, p.id ASC LIMIT 5;
