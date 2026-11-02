-- TODO 1 — Dễ: Tìm sản phẩm có giá lớn hơn giá trung bình của toàn bộ products.
-- Sắp giá giảm dần rồi id; giải thích vì sao subquery AVG chỉ trả một giá trị.

-- TODO 2 — Vừa: Dùng NOT EXISTS tìm product chưa xuất hiện trong bất kỳ order_items nào.
-- Xét mọi status: đây là chưa từng được đưa vào đơn, không phải chưa tạo doanh thu.
-- Giải thích điều kiện tương quan, và điều gì sai nếu bỏ điều kiện đó.

-- TODO 3 — Khó: Tìm product có giá lớn hơn giá trung bình của category của chính nó.
-- Dùng correlated scalar subquery; hiển thị id/name/category_id/price, sắp theo category rồi id.
-- Giải thích vì sao ngưỡng ở bài này khác bài 1 và category chỉ có một product có được trả về không.
