-- Bài 1: IDENTITY, BOOLEAN và rounding NUMERIC.
BEGIN;
CREATE TEMP TABLE solution20_amounts (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    active BOOLEAN NOT NULL DEFAULT true, amount NUMERIC(14,2) NOT NULL
) ON COMMIT DROP;
INSERT INTO solution20_amounts (amount) VALUES (1.235) RETURNING id, active, amount;

-- Bài 2: chỉ hiển thị TIMESTAMPTZ đổi theo timezone session.
SET LOCAL TIME ZONE 'UTC';
SELECT TIMESTAMP '2026-03-01 09:00:00' AS local_wall_time,
       TIMESTAMPTZ '2026-03-01 09:00:00+07' AS instant;
SET LOCAL TIME ZONE 'Asia/Ho_Chi_Minh';
SELECT TIMESTAMP '2026-03-01 09:00:00' AS local_wall_time,
       TIMESTAMPTZ '2026-03-01 09:00:00+07' AS instant;

-- Bài 3: dữ liệu demo đảm bảo warrantyMonths là số; không cast JSON tùy ý chưa validate.
CREATE TEMP TABLE solution20_product_keys (id BIGINT PRIMARY KEY) ON COMMIT DROP;
INSERT INTO solution20_product_keys SELECT id FROM products;
CREATE TEMP TABLE solution20_notes (
    product_id BIGINT NOT NULL REFERENCES solution20_product_keys(id), metadata JSONB NOT NULL
) ON COMMIT DROP;
INSERT INTO solution20_notes VALUES
    (1, '{"brand":"Acme","warrantyMonths":24}'::jsonb),
    (2, '{"brand":"Beta","warrantyMonths":12}'::jsonb),
    (3, '{}'::jsonb);
SELECT product_id, metadata ->> 'brand' AS brand, metadata -> 'warrantyMonths' AS json_value
FROM solution20_notes WHERE (metadata ->> 'warrantyMonths')::integer >= 24 ORDER BY product_id;
SELECT product_id FROM solution20_notes WHERE metadata ->> 'brand' IS NULL ORDER BY product_id;
ROLLBACK;
