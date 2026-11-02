-- Lời giải mẫu; đọc sau khi tự làm exercise.sql.
-- 1. Catalog cho biết constraint thực sự được khai báo trong schema.
SELECT c.conname AS constraint_name,
       c.contype AS constraint_type,
       pg_get_constraintdef(c.oid) AS definition
FROM pg_constraint AS c
WHERE c.conrelid = 'public.products'::regclass
ORDER BY c.conname;
-- CHECK nhận cả UNKNOWN do NULL; NOT NULL mới cấm thiếu giá trị.

-- 2. Bảng tạm và dữ liệu chỉ tồn tại trong transaction này.
BEGIN;
CREATE TEMP TABLE cart_guard (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id bigint NOT NULL UNIQUE,
    quantity integer NOT NULL CHECK (quantity > 0),
    price numeric(14, 2) NOT NULL CHECK (price >= 0)
) ON COMMIT DROP;
INSERT INTO cart_guard (product_id, quantity, price) VALUES (1, 2, 7500000);
SELECT id, product_id, quantity, price FROM cart_guard ORDER BY id;
-- INSERT INTO cart_guard (product_id, quantity, price) VALUES (2, 0, 100);
-- INSERT INTO cart_guard (product_id, quantity, price) VALUES (2, 1, NULL);
-- INSERT INTO cart_guard (product_id, quantity, price) VALUES (1, 1, 100);
-- Các lệnh trên lần lượt sai CHECK, NOT NULL và UNIQUE.
ROLLBACK;

-- 3. LEFT JOIN giữ order không có item. SUM bỏ qua NULL; COALESCE đổi thành 0.
SELECT o.id, o.total,
       COALESCE(SUM(oi.quantity * oi.price), 0) AS calculated_total
FROM orders AS o
LEFT JOIN order_items AS oi ON oi.order_id = o.id
GROUP BY o.id, o.total
HAVING o.total <> COALESCE(SUM(oi.quantity * oi.price), 0)
ORDER BY o.id;
-- item.price lưu giá lúc mua. CHECK chỉ kiểm tra dòng; FK chỉ bảo vệ liên kết.
-- Việc duy trì total cần luồng ghi trong transaction hoặc cơ chế khác được thiết kế rõ.
