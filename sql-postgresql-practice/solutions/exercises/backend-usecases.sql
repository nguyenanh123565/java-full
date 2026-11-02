-- Solutions độc lập; hằng trong WITH params thay cho input API đã được kiểm tra.
-- Khi học JDBC, bind bằng PreparedStatement; dấu ? không chạy trực tiếp trong psql.

-- Bài 1: page >= 0; 1 <= page_size <= 100; kiểm tra tràn page * size ở backend.
WITH params AS (SELECT 0::bigint AS page, 5::bigint AS page_size)
SELECT p.id, p.name, p.price, p.stock, c.name AS category_name
FROM products p JOIN categories c ON c.id = p.category_id
ORDER BY p.id ASC
LIMIT (SELECT page_size FROM params)
OFFSET (SELECT page * page_size FROM params);

-- Bài 2: 0 dòng là không tìm thấy; API chi tiết thường chuyển thành 404.
WITH params AS (SELECT 1::bigint AS product_id)
SELECT p.id, p.name, p.price, p.stock, c.id AS category_id, c.name AS category_name
FROM products p JOIN categories c ON c.id = p.category_id
WHERE p.id = (SELECT product_id FROM params);

-- Bài 3a: Một dòng là một đơn, không JOIN dòng hàng nên total không lặp.
WITH params AS (SELECT 1::bigint AS user_id)
SELECT o.id AS order_id, o.total, o.status, o.created_at
FROM orders o WHERE o.user_id = (SELECT user_id FROM params)
ORDER BY o.created_at DESC, o.id DESC;

-- Bài 3b: Lấy dòng hàng của mọi đơn thuộc user, backend nhóm theo order_id.
-- Dùng giá lịch sử. Đơn chưa có dòng hàng vẫn xuất hiện trong query 3a.
WITH params AS (SELECT 1::bigint AS user_id)
SELECT o.id AS order_id, oi.id AS item_id, p.id AS product_id,
       p.name AS product_name, oi.quantity, oi.price AS purchase_price,
       oi.quantity * oi.price AS line_total
FROM orders o JOIN order_items oi ON oi.order_id = o.id
JOIN products p ON p.id = oi.product_id
WHERE o.user_id = (SELECT user_id FROM params)
ORDER BY o.created_at DESC, o.id DESC, oi.id ASC;

-- Bài 3c: Tổng giá trị mọi đơn, gồm đơn hủy theo yêu cầu của bài.
-- Nếu nghiệp vụ chỉ tính đơn không hủy thì thêm status <> 'cancelled'.
-- Không SUM(DISTINCT total): hai đơn thật có thể cùng total.
WITH params AS (SELECT 1::bigint AS user_id)
SELECT COUNT(*) AS order_count, COALESCE(SUM(o.total), 0) AS total_order_value
FROM orders o WHERE o.user_id = (SELECT user_id FROM params);

-- Bài 4: category là tên danh mục; price là NUMERIC, không đổi sang floating point.
WITH params AS (SELECT 'robot'::text AS category_name, 5000000::numeric AS min_price)
SELECT p.id, p.name, p.price, p.stock, c.name AS category_name
FROM products p JOIN categories c ON c.id = p.category_id
WHERE c.name = (SELECT category_name FROM params)
  AND p.price >= (SELECT min_price FROM params)
ORDER BY p.id ASC;

-- Bài 5: Tổng số đơn vị trong đơn không hủy; không gọi đó là doanh thu đã thu.
WITH params AS (SELECT 5::bigint AS result_limit)
SELECT p.id AS product_id, p.name,
       SUM(oi.quantity) AS ordered_quantity,
       SUM(oi.quantity * oi.price) AS ordered_value
FROM products p JOIN order_items oi ON oi.product_id = p.id
JOIN orders o ON o.id = oi.order_id
WHERE o.status <> 'cancelled'
GROUP BY p.id, p.name
ORDER BY ordered_quantity DESC, p.id ASC
LIMIT (SELECT result_limit FROM params);
