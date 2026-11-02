-- TODO 1: GET /products?page=0&size=5.
-- Trả id, name, price, stock, category_name; phân trang, id ASC xác định thứ tự.
-- Giải thích offset, vì sao phải ORDER BY và input page/size nào cần từ chối.
-- Mô tả cách tránh tràn số khi tính page * size ở backend.
-- Khi học JDBC: các giá trị đầu vào dùng bind ?, không ghép chuỗi SQL.

-- TODO 2: GET /products/1 (đại diện GET /products/{id}).
-- Trả chi tiết sản phẩm và tên category.
-- Giải thích khóa JOIN; khi không tìm thấy id, SQL trả gì và API nên xử lý ra sao?
-- Thử với id dương không tồn tại sau khi đã làm query cho id = 1.

-- TODO 3: GET /users/1/orders (đại diện GET /users/{id}/orders).
-- Trả danh sách đơn mới nhất trước; mỗi đơn có tổng tiền, status, created_at.
-- Trả kèm dòng hàng: product_id, product_name, quantity, purchase_price, line_total.
-- Có thể dùng hai query lấy cả danh sách đơn và tất cả dòng hàng của user.
-- Giải thích bảng/khóa cần nối, cách nhóm dòng hàng theo order_id trong backend.
-- Giải thích vì sao phải dùng order_items.price, không dùng products.price.
-- Tính thêm tổng giá trị tất cả đơn của user trên bảng orders, tránh SUM(total) sau fanout.
-- Thử user 11 chưa có đơn; giải thích kết quả rỗng và tổng bằng 0.

-- TODO 4: GET /products?category=robot&minPrice=5000000.
-- Trả sản phẩm có categories.name chính xác 'robot', price >= 5.000.000, id ASC.
-- Giải thích JOIN theo khóa nào và vì sao lọc theo tên category không theo tên product.
-- Giải thích cần kiểm tra minPrice >= 0 và dùng BigDecimal khi học JDBC.

-- TODO 5: GET /reports/top-products.
-- Trả top 5 product_id, name, ordered_quantity, ordered_value.
-- Chỉ tính đơn có status khác cancelled, gồm pending, paid, shipped.
-- ordered_quantity dùng tổng quantity; ordered_value dùng quantity * giá lịch sử.
-- ORDER BY ordered_quantity DESC, product_id ASC khi đồng hạng.
-- Giải thích GROUP BY, COUNT khác SUM(quantity), vì sao đây chưa là doanh thu thực thu.
