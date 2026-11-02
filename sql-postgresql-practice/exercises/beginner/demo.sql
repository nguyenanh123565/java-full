-- Dự đoán trước: biểu thức SELECT có sửa dữ liệu không?
-- Mỗi dòng đại diện cho một sản phẩm; giá trị được tính khi đọc.
SELECT id, name, price, stock, price * stock AS inventory_value
FROM products
ORDER BY id
LIMIT 5;

-- COUNT(*) đếm dòng, không phải tổng số sản phẩm trong stock.
SELECT COUNT(*) AS product_rows FROM products;

-- current_database() giúp xác nhận đang kết nối đúng database.
SELECT current_database() AS connected_database;
