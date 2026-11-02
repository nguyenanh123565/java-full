BEGIN;
-- PostgreSQL không cho FK từ bảng TEMP tới bảng permanent.
-- Snapshot ID giúp minh họa FK giữa hai bảng tạm trong cùng transaction.
CREATE TEMP TABLE lesson20_product_keys (id BIGINT PRIMARY KEY) ON COMMIT DROP;
INSERT INTO lesson20_product_keys SELECT id FROM products;
CREATE TEMP TABLE lesson20_product_notes (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id BIGINT NOT NULL REFERENCES lesson20_product_keys(id),
    active BOOLEAN NOT NULL DEFAULT true,
    observed_at TIMESTAMP NOT NULL DEFAULT TIMESTAMP '2026-03-01 09:00:00',
    captured_at TIMESTAMPTZ NOT NULL DEFAULT TIMESTAMPTZ '2026-03-01 09:00:00+07',
    display_price NUMERIC(14,2) NOT NULL,
    metadata JSONB NOT NULL DEFAULT '{}'::jsonb
) ON COMMIT DROP;
-- Dự đoán ID, BOOLEAN, cách NUMERIC làm tròn đến 2 chữ số và kiểu giá trị JSON.
INSERT INTO lesson20_product_notes (product_id, display_price, metadata)
VALUES (1, 7500000.125, '{"brand":"Acme","warrantyMonths":24,"tags":["robot","home"]}'::jsonb)
RETURNING id, active, observed_at, captured_at, display_price;
SELECT product_id, metadata -> 'warrantyMonths' AS json_value,
       metadata ->> 'warrantyMonths' AS text_value, metadata ->> 'brand' AS brand
FROM lesson20_product_notes;
SELECT pg_get_serial_sequence('lesson20_product_notes', 'id') AS identity_sequence;
CREATE TEMP SEQUENCE lesson20_ticket_sequence START WITH 100;
SELECT nextval('lesson20_ticket_sequence') AS ticket;
-- Sequence cấp số khác identity column; rollback dữ liệu không hoàn tác nextval.
ROLLBACK;
