-- TODO 1: Dễ: ghi plan của query products category_id=1 AND price>=5000000 trên seed nhỏ; giải thích vì sao có thể Seq Scan dù index tồn tại.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.

-- TODO 2: Vừa: dùng generate_series như demo để tạo 200000 dòng trong bảng tạm; ghi EXPLAIN/EXPLAIN ANALYZE trước và sau index (category_id, price), cùng estimated/actual rows và buffers.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.

-- TODO 3: Khó: so query chọn rất ít dòng với query chọn gần toàn bảng; chạy vài lần, giải thích selectivity, cache, chi phí ghi và vì sao không ép planner tắt Seq Scan.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.
