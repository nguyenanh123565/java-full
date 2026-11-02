-- TODO 1: Thống kê products: COUNT, MIN(price), MAX(price), AVG(price), SUM(stock).
-- Giải thích COUNT(*) và SUM(stock) đang đo hai đại lượng gì.

-- TODO 2: Đếm sản phẩm và tổng stock của mỗi category, giữ cả category rỗng.
-- Giải thích COUNT(p.id), COUNT(*) khác nhau thế nào với LEFT JOIN.

-- TODO 3: Mỗi user trả về id, name, số đơn và tổng giá trị đơn không bị hủy.
-- Giữ user chưa có đơn với số liệu 0; pending cũng tính là đơn không bị hủy.
-- Giải thích vì sao đặt điều kiện status ở WHERE có thể làm mất user.
-- Giải thích vì sao không JOIN order_items khi cộng orders.total.

-- TODO 4: Tìm user có ít nhất 3 đơn không bị hủy, trả tổng giá trị các đơn đó.
-- Giải thích vì sao cần HAVING thay vì WHERE COUNT(...).

-- TODO 5: Lấy 5 sản phẩm được đặt nhiều đơn vị nhất trong các đơn không bị hủy.
-- Trả product_id, name, ordered_quantity, ordered_value dựa trên giá lịch sử.
-- Khi đồng hạng, product_id nhỏ hơn đứng trước.
-- Giải thích vì sao SUM(quantity) khác COUNT(*) và vì sao loại cancelled.
