-- Chỉ đối chiếu sau khi hoàn thành exercises/beginner/exercise.sql.
-- Bài 1: ORDER BY yêu cầu thứ tự rõ ràng; một dòng là một user.
SELECT id, name, email FROM users ORDER BY id;

-- Bài 2: Liệt kê cột làm hợp đồng dữ liệu của API rõ ràng hơn.
SELECT id, name, price, stock FROM products ORDER BY id;

-- Bài 3: Biểu thức chỉ tạo giá trị kết quả, không cập nhật bảng.
SELECT id, name, price * stock AS inventory_value FROM products ORDER BY id;

-- Bài 4: Chỉ status được chọn nên DISTINCT loại trùng theo status.
SELECT DISTINCT status FROM orders ORDER BY status;
