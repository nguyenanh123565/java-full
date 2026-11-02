-- TODO 1 — Dễ: Liệt kê các constraint của bảng products bằng catalog PostgreSQL.
-- Cho biết constraint nào bảo vệ id, price, stock và category_id.
-- Giải thích vì sao CHECK (stock >= 0) chưa đủ để cấm NULL.

-- TODO 2 — Vừa: Trong transaction, tạo TEMP TABLE cart_guard có id IDENTITY PK,
-- product_id NOT NULL, quantity NOT NULL CHECK > 0, price NUMERIC NOT NULL CHECK >= 0.
-- Thêm UNIQUE(product_id), thử một dòng hợp lệ rồi ROLLBACK.
-- Chỉ viết các lệnh cố tình sai trong comment: quantity = 0, price = NULL, product trùng.
-- Giải thích mỗi trường hợp vi phạm quy tắc nào và vì sao.

-- TODO 3 — Khó: Tìm order có total khác tổng quantity * price trong order_items.
-- Cần xét cả order chưa có dòng chi tiết: tổng khi đó được coi là 0.
-- Dùng giá tại order_items, giải thích vì sao không dùng products.price hiện tại.
-- Giải thích vì sao CHECK/FK không tự bảo đảm tổng đơn khớp các dòng chi tiết.
