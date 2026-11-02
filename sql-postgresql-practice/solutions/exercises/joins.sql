-- Bài 1: category_id là khóa ngoại của products.
SELECT p.id, p.name, p.price, c.name AS category_name
FROM products p JOIN categories c ON c.id = p.category_id
ORDER BY p.id;

-- Bài 2: Giữ mọi user; số dòng có thể nhiều hơn số user.
SELECT u.id AS user_id, u.name AS user_name, o.id AS order_id, o.status
FROM users u LEFT JOIN orders o ON o.user_id = u.id
ORDER BY u.id, o.id;

-- Bài 3: price của dòng hàng không đổi theo giá hiện tại trong products.
SELECT oi.id AS item_id, p.name AS product_name, oi.quantity,
       oi.price AS purchase_price, oi.quantity * oi.price AS line_total
FROM order_items oi JOIN products p ON p.id = oi.product_id
WHERE oi.order_id = 1 ORDER BY oi.id;

-- Bài 4: id gốc của order_items NOT NULL; NULL ở đây nghĩa là không có cặp JOIN.
SELECT p.id, p.name
FROM products p LEFT JOIN order_items oi ON oi.product_id = p.id
WHERE oi.id IS NULL ORDER BY p.id;

-- Bài 5: o.id là NULL ở dòng được LEFT JOIN bổ sung.
SELECT u.id, u.name, u.email
FROM users u LEFT JOIN orders o ON o.user_id = u.id
WHERE o.id IS NULL ORDER BY u.id;
