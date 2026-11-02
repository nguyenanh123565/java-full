-- TODO 1: Đọc id, name, price của sản phẩm cùng tên category.
-- Chỉ rõ khóa ngoại nào quyết định ON; vì sao không nối products.id = categories.id?

-- TODO 2: Liệt kê user_id, user_name, order_id, status của mọi user, kể cả chưa đặt hàng.
-- Dự đoán cột nào NULL ở users 11, 12; giải thích vì sao INNER JOIN không đáp ứng đề.

-- TODO 3: Đọc chi tiết đơn 1: product_name, quantity, purchase_price, line_total.
-- Lấy giá lịch sử từ order_items; giải thích vì sao không dùng products.price.
-- Giải thích mỗi dòng kết quả đại diện cho order hay order_item.

-- TODO 4: Tìm products chưa xuất hiện ở bất kỳ order_items nào, kể cả đơn đã hủy.
-- Giải thích vì sao dùng IS NULL trên khóa chính bên phải của LEFT JOIN.
-- Có thể thử một cách khác với NOT EXISTS sau khi học subquery.

-- TODO 5: Tìm users chưa từng có orders.
-- Giải thích vì sao kiểm tra NULL ở o.id khác với kiểm tra u.id IS NULL.
