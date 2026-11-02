-- Đoán ORDER BY nào dùng để phá hòa nếu hai sản phẩm có cùng giá?
SELECT id, name, price FROM public.products
ORDER BY price DESC, id ASC LIMIT 5;

-- Seed có ID 1..25: đoán ID trên trang 2 trước khi chạy.
SELECT id, name FROM public.products ORDER BY id LIMIT 5 OFFSET 5;

-- Phân trang theo mốc, cùng khóa ID với ORDER BY: đoán năm ID tiếp theo.
SELECT id, name FROM public.products WHERE id > 10 ORDER BY id LIMIT 5;
