-- Chỉ thực thi thủ công trong database MỚI learning_backend_jdbc.
-- Kiểm tra kết nối trước. Không chạy file này trong bài SQL/database cũ.
SELECT current_database(), current_user;
CREATE SCHEMA IF NOT EXISTS learning_jdbc;
CREATE TABLE IF NOT EXISTS learning_jdbc.products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(120) NOT NULL CHECK (length(trim(name)) > 0),
    price NUMERIC(12,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0)
);
CREATE TABLE IF NOT EXISTS learning_jdbc.stock_movements (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id BIGINT NOT NULL REFERENCES learning_jdbc.products(id),
    quantity INTEGER NOT NULL CHECK (quantity > 0)
);
-- Không tự seed. CLI add sẽ tạo dữ liệu do bạn nhập.
