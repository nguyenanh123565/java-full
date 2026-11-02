-- TODO 1 (dễ): Lấy 5 sản phẩm còn hàng có price cao nhất.
-- Trong nhóm giá bằng nhau, id nhỏ hơn đứng trước; giải thích vì sao cần khóa phụ.

-- TODO 2 (vừa): Lấy trang 2 của cùng danh sách, page size = 5.
-- Giải thích OFFSET là số dòng bỏ qua, không phải số trang.
-- Vì sao phải giữ nguyên WHERE và ORDER BY so với trang 1?

-- TODO 3 (khó): Lấy 5 sản phẩm sau last_id = 10 theo id tăng dần.
-- Giải thích phân trang theo mốc khác OFFSET ở đâu khi dữ liệu lớn hoặc thay đổi.
-- Vì sao không được giữ điều kiện id > 10 rồi đổi ORDER BY sang price DESC?
