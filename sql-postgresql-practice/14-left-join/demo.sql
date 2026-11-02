-- Dự đoán: users 11 và 12 có xuất hiện không? paid_order_id của họ là gì?
SELECT u.id AS user_id, u.name, o.id AS paid_order_id
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id AND o.status = 'paid'
WHERE u.id IN (1, 11, 12)
ORDER BY u.id, o.id;

-- Dự đoán: COUNT(*) và COUNT(o.id) có cùng bằng 0 không?
-- Hai user này chưa mua hàng nhưng LEFT JOIN vẫn tạo mỗi người một dòng giữ chỗ.
SELECT u.id AS user_id,
       COUNT(*) AS joined_rows,
       COUNT(o.id) AS real_orders
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id
WHERE u.id IN (11, 12)
GROUP BY u.id
ORDER BY u.id;
