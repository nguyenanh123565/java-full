-- 1. FK orders.user_id trỏ tới users.id; mỗi dòng là một order của user 1.
SELECT u.id AS user_id, u.name, o.id AS order_id, o.status, o.created_at
FROM users AS u
JOIN orders AS o ON o.user_id = u.id
WHERE u.id = 1
ORDER BY o.id;

-- 2. Mỗi dòng là một item. Giá lúc mua có thể khác giá bán hiện tại.
SELECT oi.id AS item_id, p.id AS product_id, p.name,
       oi.quantity, oi.price AS price_at_purchase,
       oi.quantity * oi.price AS line_total
FROM order_items AS oi
JOIN products AS p ON p.id = oi.product_id
WHERE oi.order_id = 1
ORDER BY oi.id;

-- 3. Nhiều lần mua có thể tạo nhiều dòng của cùng cặp; DISTINCT theo cặp đã chọn.
SELECT DISTINCT u.id AS user_id, u.name AS user_name,
                p.id AS product_id, p.name AS product_name
FROM users AS u
JOIN orders AS o ON o.user_id = u.id
JOIN order_items AS oi ON oi.order_id = o.id
JOIN products AS p ON p.id = oi.product_id
WHERE o.status <> 'cancelled'
ORDER BY user_id, product_id;
