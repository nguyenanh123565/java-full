-- TODO 1 (dễ): Trong BEGIN ... ROLLBACK, tạo TEMP TABLE lesson_dml_exercise.
-- Sao chép id, name, price, stock từ public.products; thêm constraint phù hợp.
-- SELECT sản phẩm id = 1 và ghi lại giá ban đầu.
-- Giải thích vì sao bản sao tạm giúp luyện DML mà không đổi seed.

-- TODO 2 (vừa): Tăng price thêm 100000 chỉ cho id = 1, dùng RETURNING.
-- Kiểm tra sản phẩm id = 2 vẫn có giá cũ; giải thích WHERE chọn phạm vi như thế nào.
-- Vì sao dùng id đáng tin cậy hơn dùng name khi name không UNIQUE?

-- TODO 3 (khó): SELECT trước, rồi DELETE các dòng stock = 0 trên bảng tạm.
-- Dùng RETURNING để xem dòng bị xóa; so sánh số dòng trước và sau rồi ROLLBACK.
-- Giải thích điều gì xảy ra nếu thiếu WHERE và vì sao DELETE khác DROP TABLE.
-- Vì sao không nên áp dụng việc xóa này ngay lên public.products có order_items tham chiếu?
