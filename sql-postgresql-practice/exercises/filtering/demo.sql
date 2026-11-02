-- Dự đoán: stock = 0 có được giữ lại không? WHERE chỉ giữ TRUE.
SELECT id, name, stock FROM products WHERE stock > 0 ORDER BY id LIMIT 5;

-- Mốc +07 rõ ràng, không phụ thuộc timezone mặc định của phiên làm việc.
SELECT id, status, created_at FROM orders
WHERE created_at >= TIMESTAMPTZ '2026-01-01 00:00:00+07'
  AND created_at < TIMESTAMPTZ '2026-02-01 00:00:00+07'
ORDER BY created_at, id;
