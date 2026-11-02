BEGIN;
CREATE TEMP TABLE lesson_insert_products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0)
) ON COMMIT DROP;

-- Đoán số dòng RETURNING và stock khi cột stock bị bỏ qua.
INSERT INTO lesson_insert_products (name, price)
VALUES ('Robot A', 7500000), ('Robot B', 5200000)
RETURNING id, name, price, stock;

SELECT COUNT(*) AS inserted_rows FROM lesson_insert_products;
ROLLBACK;
