-- 1. Database là đích kết nối; schema là không gian tên bên trong database.
SELECT current_database() AS database_name, current_schema() AS schema_name;

-- 2. Một dòng là một user; id/name/email là các thuộc tính được chiếu ra.
-- ORDER BY xác định rõ ba ID nhỏ nhất, không phụ thuộc thứ tự lưu trữ.
SELECT id, name, email FROM public.users ORDER BY id LIMIT 3;

-- 3. Một order chứa nhiều dòng hàng; COUNT(*) đếm đúng thực thể của từng bảng.
SELECT 'users' AS table_name, COUNT(*) AS row_count FROM public.users
UNION ALL
SELECT 'categories', COUNT(*) FROM public.categories
UNION ALL
SELECT 'products', COUNT(*) FROM public.products
UNION ALL
SELECT 'orders', COUNT(*) FROM public.orders
UNION ALL
SELECT 'order_items', COUNT(*) FROM public.order_items;
