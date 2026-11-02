-- Đoán ID 1 và 2 có qua bộ lọc giá này không?
SELECT id, name, price, stock FROM public.products
WHERE stock > 0 AND price BETWEEN 1000000 AND 5000000
ORDER BY id;

-- Ngoặc bắt buộc theo ý định: cả hai danh mục đều phải còn hàng.
SELECT id, category_id, stock FROM public.products
WHERE (category_id = 1 OR category_id = 2) AND stock > 0
ORDER BY id;

-- Đoán 3 boolean: so sánh NULL trả UNKNOWN, hiển thị thành NULL.
SELECT NULL::TEXT = NULL::TEXT AS equal_unknown,
       NULL::TEXT IS NULL AS missing,
       ''::TEXT IS NULL AS empty_is_missing;
