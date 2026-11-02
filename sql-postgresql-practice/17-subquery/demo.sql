-- Dự đoán: mọi product có chung một ngưỡng giá hay ngưỡng thay đổi theo dòng?
SELECT id, name, price
FROM products
WHERE price > (SELECT AVG(price) FROM products)
ORDER BY price DESC, id;

-- Dự đoán: users 11 và 12 có được giữ không? Correlation nằm ở đâu?
SELECT u.id, u.name
FROM users AS u
WHERE NOT EXISTS (
    SELECT 1
    FROM orders AS o
    WHERE o.user_id = u.id
)
ORDER BY u.id;
