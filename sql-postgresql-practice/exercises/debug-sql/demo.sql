-- Công cụ điều tra: đo số dòng JOIN của mỗi order trước khi tổng hợp theo user.
-- Dự đoán đơn 1: order_total = 8.900.000 và có 2 dòng hàng.
-- value_if_sum_after_join minh họa mức nhân tổng nếu cộng total ở mỗi dòng hàng.
SELECT o.id AS order_id, o.total AS order_total, COUNT(oi.id) AS item_rows,
       o.total * COUNT(oi.id) AS value_if_sum_after_join
FROM orders o JOIN order_items oi ON oi.order_id = o.id
WHERE o.id IN (1, 2, 3)
GROUP BY o.id, o.total ORDER BY o.id;

-- information_schema giúp tra tên cột, không cần đoán quan hệ từ tên id.
SELECT table_name, column_name, data_type
FROM information_schema.columns
WHERE table_schema = 'public' AND table_name IN ('orders', 'order_items')
ORDER BY table_name, ordinal_position;
