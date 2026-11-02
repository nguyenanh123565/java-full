-- TODO 1 — Dễ: Lấy mọi user cùng order id nếu có; sắp xếp theo user id rồi order id.
-- Giải thích vì sao users 11,12 có NULL ở cột order id dù orders.id là NOT NULL.

-- TODO 2 — Vừa: Tìm user chưa từng tạo order, chỉ hiển thị user id/name.
-- Dùng LEFT JOIN và IS NULL; giải thích vì sao '= NULL' không đúng.

-- TODO 3 — Khó: Lấy mọi user và số order paid của họ, kể cả người có số lượng 0.
-- Đặt điều kiện status ở vị trí bảo toàn mọi user; dùng GROUP BY khi cần.
-- Giải thích ON khác WHERE và COUNT(o.id) khác COUNT(*) trong bài này như thế nào.
