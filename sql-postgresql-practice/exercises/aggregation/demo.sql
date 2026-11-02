-- Dự đoán trước: một dòng đại diện cho một đơn hay một trạng thái?
SELECT status, COUNT(*) AS order_count, SUM(total) AS order_value
FROM orders GROUP BY status ORDER BY status;

-- LEFT JOIN có một dòng bổ sung cho user chưa có đơn.
-- COUNT(*) đếm dòng bổ sung đó; COUNT(o.id) bỏ qua NULL.
SELECT u.id, COUNT(*) AS joined_rows, COUNT(o.id) AS actual_orders
FROM users u LEFT JOIN orders o ON o.user_id = u.id
WHERE u.id IN (1, 11, 12)
GROUP BY u.id ORDER BY u.id;
