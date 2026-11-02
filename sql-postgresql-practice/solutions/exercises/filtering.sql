-- Bài 1.
SELECT id, name, stock FROM products WHERE stock > 0 ORDER BY id;

-- Bài 2: BETWEEN gồm hai đầu mút.
SELECT id, name, price FROM products
WHERE price BETWEEN 1000000 AND 5000000 ORDER BY price, id;

-- Bài 3: AND ưu tiên hơn OR; ngoặc giữ đúng ý nghĩa nghiệp vụ.
SELECT id, name, price, stock, category_id FROM products
WHERE stock > 0 AND (category_id = 1 OR price < 1000000)
ORDER BY id;

-- Bài 4: ILIKE là cách so khớp không phân biệt hoa/thường của PostgreSQL.
SELECT id, name, email FROM users WHERE name ILIKE '%an%' ORDER BY id;

-- Bài 5: Khoảng nửa mở bao phủ mọi phần giây trong tháng.
SELECT id, user_id, total, status, created_at FROM orders
WHERE created_at >= TIMESTAMPTZ '2026-01-01 00:00:00+07'
  AND created_at < TIMESTAMPTZ '2026-02-01 00:00:00+07'
ORDER BY created_at, id;
