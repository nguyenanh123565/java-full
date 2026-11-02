-- Dự đoán trước: mỗi dòng kết quả là một order hay một order_item?
-- Đơn 1 có hai dòng hàng; total của đơn lặp lại ở hai dòng.
SELECT o.id AS order_id, o.total AS order_total, oi.id AS item_id,
       p.name AS product_name, oi.quantity, oi.price AS purchase_price
FROM orders o
JOIN order_items oi ON oi.order_id = o.id
JOIN products p ON p.id = oi.product_id
WHERE o.id = 1
ORDER BY oi.id;

-- Quan sát cột phải thành NULL dù orders.user_id là NOT NULL trong bảng.
SELECT u.id AS user_id, u.name, o.id AS order_id
FROM users u
LEFT JOIN orders o ON o.user_id = u.id
WHERE u.id IN (11, 12)
ORDER BY u.id, o.id;
