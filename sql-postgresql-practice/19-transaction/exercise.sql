-- TODO 1: Dễ: đặt 2 sản phẩm id=1 cho user1: BEGIN, lấy giá/khóa dòng, tạo order và items, giảm stock rồi COMMIT. Giải thích vì sao phải chung transaction.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.

-- TODO 2: Vừa: cố đặt 999 sản phẩm id=1; phát hiện thiếu stock rồi ROLLBACK. Kiểm tra số order/items và stock không đổi, giải thích ảnh hưởng của row lock.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.

-- TODO 3: Khó: tạo order rồi chèn quantity=0 để cố tình vi phạm CHECK; quan sát transaction aborted và ROLLBACK. Sau đó tự thiết kế hai session đặt hàng đồng thời và giải thích không bán vượt kho.
-- TODO: Giải thích vì sao đúng; ghi dự đoán và kiểm tra trường hợp biên.
