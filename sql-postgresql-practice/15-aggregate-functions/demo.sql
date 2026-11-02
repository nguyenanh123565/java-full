-- Dự đoán trước: item_count = ?, unit_count = ?, order_total = ?
-- Order 1 có product 1 x 1 giá 7500000 và product 16 x 2 giá 700000.
SELECT COUNT(*) AS item_count,
       SUM(quantity) AS unit_count,
       SUM(quantity * price) AS order_total
FROM order_items
WHERE order_id = 1;

-- Dự đoán kết quả khi không có dòng nào: COUNT và SUM có giống nhau không?
SELECT COUNT(*) AS item_count,
       SUM(quantity * price) AS raw_total,
       COALESCE(SUM(quantity * price), 0) AS total_for_api
FROM order_items
WHERE order_id = -1;
