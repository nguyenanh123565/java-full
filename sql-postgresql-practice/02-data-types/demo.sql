-- Đoán cả ba kết quả trước khi chạy; cast thay đổi kiểu của phép chia.
SELECT 5 / 2 AS integer_division,
       5::NUMERIC / 2 AS decimal_division,
       10.129::NUMERIC(14,2) AS rounded_price;

BEGIN;
CREATE TEMP TABLE lesson_data_types (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL CHECK (stock >= 0),
    active BOOLEAN NOT NULL,
    created_at TIMESTAMPTZ NOT NULL
) ON COMMIT DROP;

-- Dự đoán price sau khi ghi: scale của cột là 2.
INSERT INTO lesson_data_types (name, price, stock, active, created_at)
VALUES ('Robot thử nghiệm', 10.129, 3, TRUE, TIMESTAMPTZ '2026-01-01 09:00:00+07');
SELECT name, price, stock, active, created_at FROM lesson_data_types;
ROLLBACK;
