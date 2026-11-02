-- TODO 1 — Dễ: Với mỗi category, lấy id/name và số products, kể cả category rỗng.
-- Sắp xếp theo category id; giải thích vì sao GROUP BY id/name và COUNT(p.id).

-- TODO 2 — Vừa: Với mọi user, tính số orders paid/shipped và tổng orders.total của chúng.
-- Giữ user có 0 order hợp lệ; trả tổng 0 nếu không có order, sắp theo user id.
-- Giải thích ON, WHERE, COUNT và COALESCE trong lựa chọn của bạn.

-- TODO 3 — Khó: Tính số lượng bán và doanh thu lịch sử cho mọi category,
-- chỉ tính orders paid/shipped, vẫn giữ category chưa bán với hai tổng bằng 0.
-- Sau đó viết query thứ hai chỉ giữ category có số lượng bán >= 3 bằng HAVING.
-- Giải thích cách tránh cộng items của pending/cancelled và tránh nhân tổng orders.total.
