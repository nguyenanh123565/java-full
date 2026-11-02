BEGIN;
-- 1. Bản sao thuộc session, không mang FK tới order_items của dữ liệu thật.
CREATE TEMP TABLE lesson_dml_exercise (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL CHECK (stock >= 0)
) ON COMMIT DROP;
INSERT INTO lesson_dml_exercise (id, name, price, stock)
SELECT id, name, price, stock FROM public.products;
SELECT id, name, price FROM lesson_dml_exercise WHERE id = 1;

-- 2. PK xác định một dòng; name không có cam kết duy nhất trong schema.
UPDATE lesson_dml_exercise SET price = price + 100000 WHERE id = 1
RETURNING id, price;
SELECT id, price FROM lesson_dml_exercise WHERE id IN (1, 2) ORDER BY id;

-- 3. DELETE bỏ các dòng khớp điều kiện; DROP bỏ cả đối tượng bảng.
SELECT COUNT(*) AS before_delete FROM lesson_dml_exercise;
SELECT id, stock FROM lesson_dml_exercise WHERE stock = 0 ORDER BY id;
DELETE FROM lesson_dml_exercise WHERE stock = 0 RETURNING id, name;
SELECT COUNT(*) AS after_delete FROM lesson_dml_exercise;
-- Thiếu WHERE sẽ xóa mọi dòng. Ở public, FK còn bảo vệ lịch sử order_items.
ROLLBACK;
