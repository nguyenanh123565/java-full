-- TODO 1 — Dễ: Lấy id/name của user 1 cùng id/status/created_at của các order của họ.
-- Giải thích khóa nối và vì sao một user có thể xuất hiện nhiều dòng.

-- TODO 2 — Vừa: Lấy toàn bộ sản phẩm thuộc order 1, tên sản phẩm, quantity,
-- giá lúc mua và tiền từng dòng. Sắp xếp theo id của order_items.
-- Giải thích mỗi dòng đại diện gì và vì sao dùng order_items.price.

-- TODO 3 — Khó: Lấy các cặp user–product đã xuất hiện trong order không cancelled.
-- Mỗi cặp user_id/product_id chỉ xuất hiện một lần, dù mua nhiều lần.
-- Hiển thị cả tên user và tên product; sắp xếp theo hai id.
-- Giải thích bảng nối giải quyết quan hệ nhiều–nhiều và vì sao cần DISTINCT.
