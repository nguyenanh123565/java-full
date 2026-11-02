-- TODO 1 — Dễ: Tính số sản phẩm, giá nhỏ nhất, giá lớn nhất và giá trung bình.
-- Giải thích vì sao kết quả chỉ có một dòng dù products có nhiều dòng.

-- TODO 2 — Vừa: Với orders paid hoặc shipped, tính số order khác nhau,
-- tổng số đơn vị sản phẩm đã bán và tổng doanh thu từ quantity * giá lúc mua.
-- Giải thích vì sao COUNT(*) không phải số order và không được SUM(o.total) sau JOIN items.
-- Nêu rõ vì sao pending và cancelled không được tính theo chính sách bài này.

-- TODO 3 — Khó: Chỉ xét users 11 và 12, LEFT JOIN orders rồi tính COUNT(*),
-- COUNT(o.id), SUM(o.total) và COALESCE(SUM(o.total), 0) trong một dòng kết quả.
-- Dự đoán cả bốn giá trị và giải thích sự khác biệt trước khi chạy.
