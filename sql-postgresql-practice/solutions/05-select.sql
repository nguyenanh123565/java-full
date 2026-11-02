-- 1. Hình dạng kết quả rõ ràng; thêm cột ở schema không tự mở rộng kết quả.
SELECT id, name, price FROM public.products ORDER BY id;

-- 2. Biểu thức được tính khi đọc; alias chỉ đặt tên kết quả.
-- Đây là giá bán hiện tại nhân tồn kho, không phản ánh dòng hàng đã bán.
SELECT id, name, price * stock AS inventory_value
FROM public.products ORDER BY id;

-- 3. DISTINCT loại trùng theo toàn bộ tổ hợp cột được chọn.
SELECT DISTINCT category_id FROM public.products ORDER BY category_id;
SELECT DISTINCT category_id, name FROM public.products ORDER BY category_id, name;
-- Hai sản phẩm cùng category nhưng khác name vẫn là hai dòng khác nhau ở query 2.
