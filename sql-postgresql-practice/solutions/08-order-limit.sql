-- 1. ID duy nhất phá hòa trong nhóm giá bằng nhau.
SELECT id, name, price FROM public.products
WHERE stock > 0 ORDER BY price DESC, id ASC LIMIT 5;

-- 2. OFFSET = (page - 1) * page_size = 5; cùng bộ lọc và thứ tự.
SELECT id, name, price FROM public.products
WHERE stock > 0 ORDER BY price DESC, id ASC LIMIT 5 OFFSET 5;

-- 3. Mốc ID và thứ tự ID nhất quán; không phải trang kế của thứ tự giá ở trên.
SELECT id, name, price FROM public.products
WHERE id > 10 ORDER BY id ASC LIMIT 5;
-- OFFSET bỏ qua các dòng trước; mốc tiếp tục từ khóa đã thấy.
-- Một thay đổi trước trang OFFSET có thể dịch vị trí. Mốc vẫn cần khóa ổn định.
-- Sắp theo price đòi hỏi mốc phù hợp với price và ID, không chỉ một last_id.
