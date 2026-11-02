-- 1. Nhóm theo category; COUNT(p.id) không đếm dòng giữ chỗ của category rỗng.
SELECT c.id, c.name, COUNT(p.id) AS product_count
FROM categories AS c
LEFT JOIN products AS p ON p.category_id = c.id
GROUP BY c.id, c.name
ORDER BY c.id;

-- 2. Không nối items, nên tổng của mỗi order chỉ được cộng đúng một lần.
SELECT u.id, u.name, COUNT(o.id) AS completed_order_count,
       COALESCE(SUM(o.total), 0) AS completed_total
FROM users AS u
LEFT JOIN orders AS o
       ON o.user_id = u.id AND o.status IN ('paid', 'shipped')
GROUP BY u.id, u.name
ORDER BY u.id;

-- 3a. Lọc items hợp lệ trong subquery trước, rồi LEFT JOIN từ mọi category.
-- cancelled và pending không thể tham gia nhánh sold_items.
SELECT c.id, c.name,
       COALESCE(SUM(sold_items.quantity), 0) AS units_sold,
       COALESCE(SUM(sold_items.quantity * sold_items.price), 0) AS revenue
FROM categories AS c
LEFT JOIN products AS p ON p.category_id = c.id
LEFT JOIN (
    SELECT oi.product_id, oi.quantity, oi.price
    FROM order_items AS oi
    JOIN orders AS o ON o.id = oi.order_id
    WHERE o.status IN ('paid', 'shipped')
) AS sold_items ON sold_items.product_id = p.id
GROUP BY c.id, c.name
ORDER BY c.id;

-- 3b. HAVING lọc kết quả nhóm; không thay bằng WHERE SUM(...).
SELECT c.id, c.name,
       COALESCE(SUM(sold_items.quantity), 0) AS units_sold,
       COALESCE(SUM(sold_items.quantity * sold_items.price), 0) AS revenue
FROM categories AS c
LEFT JOIN products AS p ON p.category_id = c.id
LEFT JOIN (
    SELECT oi.product_id, oi.quantity, oi.price
    FROM order_items AS oi
    JOIN orders AS o ON o.id = oi.order_id
    WHERE o.status IN ('paid', 'shipped')
) AS sold_items ON sold_items.product_id = p.id
GROUP BY c.id, c.name
HAVING COALESCE(SUM(sold_items.quantity), 0) >= 3
ORDER BY revenue DESC, c.id;
