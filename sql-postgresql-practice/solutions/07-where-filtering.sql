-- 1. > 0 biểu diễn còn hàng; >= 0 giữ cả sản phẩm hết hàng.
SELECT id, name, stock FROM public.products WHERE stock > 0 ORDER BY id;

-- 2. BETWEEN bao gồm hai đầu mút; AND yêu cầu cả giá và stock cùng hợp lệ.
SELECT id, name, price, stock FROM public.products
WHERE stock > 0 AND price BETWEEN 1000000 AND 5000000 ORDER BY id;
SELECT id, name, price, stock FROM public.products
WHERE stock > 0 AND price >= 1000000 AND price <= 5000000 ORDER BY id;

-- 3. AND ưu tiên hơn OR; ngoặc hoặc IN diễn đạt đúng cả hai danh mục.
SELECT id, category_id, stock FROM public.products
WHERE (category_id = 1 OR category_id = 2) AND stock > 0 ORDER BY id;
SELECT id, category_id, stock FROM public.products
WHERE category_id IN (1, 2) AND stock > 0 ORDER BY id;

-- NULL là thiếu giá trị; = NULL cho UNKNOWN nên WHERE không giữ dòng.
SELECT label, optional_name
FROM (VALUES ('có tên', 'An'::TEXT), ('thiếu tên', NULL::TEXT), ('rỗng', ''::TEXT))
     AS sample(label, optional_name)
WHERE optional_name IS NULL;
