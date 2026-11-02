BEGIN;
CREATE TEMP TABLE lesson_fk_categories (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL
) ON COMMIT DROP;
CREATE TEMP TABLE lesson_fk_products (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    category_id BIGINT NOT NULL REFERENCES lesson_fk_categories(id) ON DELETE RESTRICT
) ON COMMIT DROP;

-- Dự đoán: cha không có con có vi phạm FK không?
INSERT INTO lesson_fk_categories (id, name) VALUES (1, 'robot'), (2, 'books');
INSERT INTO lesson_fk_products (id, name, category_id) VALUES (1, 'Robot demo', 1);
SELECT id, name, category_id FROM lesson_fk_products;
-- Không chạy lỗi: INSERT ... category_id = 999 khi cha 999 không tồn tại.
-- Không chạy lỗi: DELETE FROM lesson_fk_categories WHERE id = 1;
-- RESTRICT bảo vệ category 1 còn được product tham chiếu.
DELETE FROM lesson_fk_categories WHERE id = 2 RETURNING id, name;
ROLLBACK;
