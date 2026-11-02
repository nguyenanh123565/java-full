BEGIN;
CREATE TEMP TABLE lesson_insert_exercise (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0)
) ON COMMIT DROP;

-- 1. Cột identity sinh ID; danh sách cột diễn đạt rõ ánh xạ giá trị.
INSERT INTO lesson_insert_exercise (name, price, stock)
VALUES ('Robot C', 6000000, 5);

-- 2. Stock 0 nghĩa là biết chắc hết hàng; NULL nghĩa là không có giá trị.
INSERT INTO lesson_insert_exercise (name, price, stock)
VALUES ('Robot D', 5000000, 0), ('Robot E', 4000000, 8);

-- 3. Bỏ qua stock nên nhận DEFAULT; RETURNING lấy ID của chính dòng được ghi.
INSERT INTO lesson_insert_exercise (name, price)
VALUES ('Robot F', 3000000)
RETURNING id, price, stock;
-- Không chạy dòng sai; cả câu lệnh thất bại nếu bất kỳ dòng nào vi phạm CHECK:
-- INSERT INTO lesson_insert_exercise (name, price, stock)
-- VALUES ('Hợp lệ', 100, 1), ('Không hợp lệ', 100, -1);
SELECT id, name, price, stock FROM lesson_insert_exercise ORDER BY id;
ROLLBACK;
