-- Dự đoán: page = 0, size = 3, offset là bao nhiêu?
-- Đây là hằng mẫu SQL; JDBC sẽ bind input đã kiểm tra bằng PreparedStatement.
WITH params AS (SELECT 0::bigint AS page, 3::bigint AS page_size)
SELECT p.id, p.name, p.price, p.stock
FROM products p ORDER BY p.id ASC
LIMIT (SELECT page_size FROM params)
OFFSET (SELECT page * page_size FROM params);

-- Cột này chỉ là giá trị của một dòng hàng, dùng giá tại lúc mua.
-- Dự đoán đơn 1 có bao nhiêu dòng và line_total từng dòng.
SELECT oi.order_id, oi.id AS item_id, oi.quantity,
       oi.price AS purchase_price, oi.quantity * oi.price AS line_total
FROM order_items oi WHERE oi.order_id = 1 ORDER BY oi.id;
