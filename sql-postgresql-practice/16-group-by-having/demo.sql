-- Dự đoán: có bao nhiêu dòng? Users 11 và 12 có order_count bằng bao nhiêu?
SELECT u.id, u.name, COUNT(o.id) AS order_count
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id
GROUP BY u.id, u.name
ORDER BY u.id;

-- Dự đoán: WHERE lọc status và HAVING lọc nhóm như thế nào?
SELECT user_id, COUNT(*) AS paid_order_count, SUM(total) AS paid_total
FROM orders
WHERE status = 'paid'
GROUP BY user_id
HAVING COUNT(*) >= 2
ORDER BY paid_total DESC, user_id;
