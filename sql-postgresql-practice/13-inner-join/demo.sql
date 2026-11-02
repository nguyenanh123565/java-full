-- Dự đoán: users 11 và 12 có xuất hiện không? Vì sao?
SELECT u.id AS user_id, u.name AS user_name,
       o.id AS order_id, o.status, o.total
FROM users AS u
INNER JOIN orders AS o ON o.user_id = u.id
ORDER BY u.id, o.id;

-- Dự đoán: order 1 xuất hiện mấy dòng khi nối thêm bảng chi tiết?
SELECT o.id AS order_id, oi.product_id, oi.quantity
FROM orders AS o
INNER JOIN order_items AS oi ON oi.order_id = o.id
WHERE o.id = 1
ORDER BY oi.id;
