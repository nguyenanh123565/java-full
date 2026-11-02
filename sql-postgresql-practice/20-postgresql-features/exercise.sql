-- TODO 1: Dễ: tạo bảng tạm có IDENTITY/BOOLEAN/NUMERIC(14,2), INSERT bỏ id rồi RETURNING; thử 1.235 và giải thích kết quả.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.

-- TODO 2: Vừa: so TIMESTAMP 2026-03-01 09:00 với TIMESTAMPTZ 2026-03-01 09:00+07 khi đổi session timezone UTC và Asia/Ho_Chi_Minh trong transaction; giải thích cái nào đổi hiển thị.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.

-- TODO 3: Khó: tạo bảng tạm snapshot ID products có PK, rồi bảng tạm metadata JSONB có FK tới snapshot; đọc brand/warrantyMonths, lọc warranty >=24, kiểm tra field thiếu IS NULL. Giải thích ->/->>, cast và vì sao không bỏ FK (TEMP không được FK tới bảng permanent).
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.
