BEGIN;
-- 1. Định nghĩa cột không tạo dòng dữ liệu.
CREATE TEMP TABLE lesson_product_draft (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL
) ON COMMIT DROP;
SELECT COUNT(*) AS rows_after_create FROM lesson_product_draft;

-- 2. Kiểu xác định miền giá trị; CHECK giới hạn nghiệp vụ; NOT NULL cấm thiếu.
-- DEFAULT cung cấp giá trị khi cột bị bỏ qua, không sửa một NULL truyền rõ.
ALTER TABLE lesson_product_draft
    ADD COLUMN price NUMERIC(14,2) NOT NULL CHECK (price >= 0),
    ADD COLUMN stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0);

-- 3. Identity sinh ID, DEFAULT cung cấp stock/thời điểm khi INSERT bỏ cột.
ALTER TABLE lesson_product_draft
    ADD COLUMN created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP;
INSERT INTO lesson_product_draft (name, price) VALUES ('Robot bản nháp', 1000000);
SELECT id, name, price, stock, created_at FROM lesson_product_draft;
-- IF NOT EXISTS không đổi cấu trúc bảng đã có; ALTER mới diễn đạt thay đổi.
ROLLBACK;
