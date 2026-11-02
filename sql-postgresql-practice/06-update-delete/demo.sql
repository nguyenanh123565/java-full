BEGIN;
CREATE TEMP TABLE lesson_update_delete (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL CHECK (stock >= 0)
) ON COMMIT DROP;
INSERT INTO lesson_update_delete (id, name, price, stock)
SELECT id, name, price, stock FROM public.products;

-- Đoán stock mới của ID 1; kiểm tra đúng phạm vi trước khi ghi.
SELECT id, stock FROM lesson_update_delete WHERE id = 1;
UPDATE lesson_update_delete SET stock = stock + 2 WHERE id = 1
RETURNING id, stock;

-- Đoán những ID bị xóa; chỉ bản sao tạm bị tác động.
SELECT id, stock FROM lesson_update_delete WHERE stock = 0 ORDER BY id;
DELETE FROM lesson_update_delete WHERE stock = 0 RETURNING id, name;
ROLLBACK;
