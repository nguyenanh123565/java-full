BEGIN;
-- Bảng tạm nằm trong CÙNG database; không thêm dữ liệu giả vào 5 bảng gốc.
CREATE TEMP TABLE lesson18_products (
    id BIGINT, name TEXT, price NUMERIC(14,2), stock INTEGER, category_id BIGINT
) ON COMMIT DROP;
INSERT INTO lesson18_products (id, name, price, stock, category_id)
SELECT g, 'Lab product ' || g, (g % 50000) * 100 + 10000, g % 100, g % 5 + 1
FROM generate_series(1, 200000) AS s(g);
ANALYZE lesson18_products;

-- Dự đoán scan nào khi chưa có index. EXPLAIN chỉ lập kế hoạch.
EXPLAIN SELECT id, name, price FROM lesson18_products
WHERE category_id = 1 AND price >= 4900000 AND price < 4901000;
-- ANALYZE thực sự chạy SELECT; BUFFERS cho thấy mức truy cập buffer.
EXPLAIN (ANALYZE, BUFFERS) SELECT id, name, price FROM lesson18_products
WHERE category_id = 1 AND price >= 4900000 AND price < 4901000;

CREATE INDEX lesson18_category_price_idx ON lesson18_products (category_id, price);
ANALYZE lesson18_products;
-- So sánh plan, estimated/actual rows, buffers; timing có thể bị cache ảnh hưởng.
EXPLAIN (ANALYZE, BUFFERS) SELECT id, name, price FROM lesson18_products
WHERE category_id = 1 AND price >= 4900000 AND price < 4901000;
-- Chọn gần toàn bảng: PostgreSQL vẫn có thể thích Seq Scan.
EXPLAIN (ANALYZE, BUFFERS) SELECT * FROM lesson18_products WHERE price >= 10000;
ROLLBACK;
