BEGIN;
CREATE TEMP TABLE lesson_create_table (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0)
) ON COMMIT DROP;

-- Đoán COUNT(*) trước INSERT: tạo cấu trúc không tạo dòng.
SELECT COUNT(*) AS rows_after_create FROM lesson_create_table;
-- Bỏ qua id và stock: database dùng identity/default.
INSERT INTO lesson_create_table (name) VALUES ('Robot demo');
SELECT id, name, stock FROM lesson_create_table;
ROLLBACK;
