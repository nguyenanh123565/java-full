-- Dự đoán: query nào trả đúng một dòng? COUNT(*) đếm dòng hay cột?
SELECT current_database() AS database_name,
       current_schema() AS schema_name,
       current_user AS connection_user;

-- Một sản phẩm là một dòng; ORDER BY quyết định thứ tự hiển thị.
SELECT id, name FROM public.products ORDER BY id LIMIT 3;

-- Hai số đếm mô tả hai loại thực thể khác nhau.
SELECT (SELECT COUNT(*) FROM public.orders) AS orders_count,
       (SELECT COUNT(*) FROM public.order_items) AS order_items_count;
