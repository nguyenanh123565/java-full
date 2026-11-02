-- TODO 1 (dễ): Trong BEGIN ... ROLLBACK, tạo TEMP TABLE lesson_insert_exercise
-- có id identity primary key, name not null, price không âm và stock không âm.
-- Đặt stock mặc định 0; INSERT một sản phẩm hợp lệ với danh sách cột rõ ràng.
-- Giải thích vì sao không cần tự nhập id.

-- TODO 2 (vừa): INSERT hai sản phẩm bằng một câu lệnh, có một sản phẩm stock = 0.
-- Giải thích vì sao 0 khác NULL và vì sao thứ tự VALUES phải khớp danh sách cột.

-- TODO 3 (khó): INSERT một sản phẩm chỉ truyền name và price, dùng RETURNING id, price, stock.
-- Giải thích vì sao stock nhận default và RETURNING hữu ích cho POST /products.
-- Viết bằng comment một INSERT hai dòng mà dòng thứ hai có stock âm.
-- Dự đoán có dòng nào trong câu lệnh sai được ghi không; rollback để chạy lại bài.
