-- 1. Mỗi product trỏ tới category qua products.category_id.
SELECT p.id, p.name, p.price, c.name AS category_name
FROM products AS p
JOIN categories AS c ON c.id = p.category_id
WHERE c.name = 'robot'
ORDER BY p.id;

-- 2. Mỗi order có một user; nối với PK users.id không nhân số dòng của order.
SELECT o.id AS order_id, u.name AS user_name, o.status, o.total
FROM orders AS o
JOIN users AS u ON u.id = o.user_id
WHERE o.status = 'paid'
ORDER BY o.id;

-- 3. Một dòng là một item, do đó không cộng o.total trên kết quả này.
SELECT o.id AS order_id, u.name AS user_name, p.name AS product_name,
       oi.quantity, oi.price AS price_at_purchase,
       oi.quantity * oi.price AS line_total
FROM orders AS o
JOIN users AS u ON u.id = o.user_id
JOIN order_items AS oi ON oi.order_id = o.id
JOIN products AS p ON p.id = oi.product_id
WHERE o.status IN ('paid', 'shipped')
ORDER BY o.id, oi.id;
-- Nếu muốn tổng tiền từ chi tiết, cộng line_total; nếu dùng o.total thì tổng từ orders.
