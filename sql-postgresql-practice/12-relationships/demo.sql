-- Dự đoán số dòng, tên user lặp mấy lần, và tổng hai dòng trước khi chạy.
-- Order 1: product 1 x 1 giá 7500000; product 16 x 2 giá 700000.
SELECT o.id AS order_id,
       u.name AS user_name,
       p.name AS product_name,
       oi.quantity,
       oi.price AS price_at_purchase,
       oi.quantity * oi.price AS line_total
FROM orders AS o
JOIN users AS u ON u.id = o.user_id
JOIN order_items AS oi ON oi.order_id = o.id
JOIN products AS p ON p.id = oi.product_id
WHERE o.id = 1
ORDER BY oi.id;
-- Mỗi dòng là một order item; order/user lặp lại vì quan hệ một–nhiều.
