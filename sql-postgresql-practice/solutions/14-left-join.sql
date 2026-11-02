-- 1. Một user có thể có nhiều dòng; không có order thì phía orders được bổ sung NULL.
SELECT u.id AS user_id, u.name, o.id AS order_id
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id
ORDER BY u.id, o.id;

-- 2. id của order thật luôn có giá trị; NULL ở đây biểu thị không tìm được order.
SELECT u.id, u.name
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id
WHERE o.id IS NULL
ORDER BY u.id;
-- '= NULL' trả UNKNOWN nên không đáp ứng điều kiện WHERE.

-- 3. ON chỉ chọn các order paid để nối, không loại user bên trái.
SELECT u.id, u.name, COUNT(o.id) AS paid_order_count
FROM users AS u
LEFT JOIN orders AS o ON o.user_id = u.id AND o.status = 'paid'
GROUP BY u.id, u.name
ORDER BY u.id;
-- COUNT(*) sẽ đếm dòng giữ chỗ; COUNT(o.id) bỏ id NULL nên trả 0 đúng nghĩa.
