-- Đoán inventory_value của id = 5 (stock = 0) trước khi chạy.
-- AS đặt tên kết quả, không tạo cột được lưu trong products.
SELECT id, name, price, stock, price * stock AS inventory_value
FROM public.products
ORDER BY id
LIMIT 5;

-- DISTINCT áp dụng cho toàn bộ danh sách được SELECT.
SELECT DISTINCT category_id FROM public.products ORDER BY category_id;
