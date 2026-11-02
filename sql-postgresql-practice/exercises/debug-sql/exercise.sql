-- Tất cả query dưới đây CỐ TÌNH SAI và chỉ là comment, không được chạy DML sai.

-- TODO 1: JOIN sai key. Mục tiêu: trả tên người đặt mỗi đơn.
-- Query sai:
-- SELECT o.id AS order_id, u.name FROM orders o JOIN users u ON o.id = u.id;
-- Vì sao query vẫn có thể chạy? Chỉ rõ khóa ngoại thật và sửa điều kiện JOIN.
-- Kiểm tra một user có nhiều đơn để chứng minh câu sửa đúng.

-- TODO 2: WHERE NULL sai. Mục tiêu: tìm sản phẩm chưa xuất hiện trong order_items.
-- Query sai:
-- SELECT p.id, p.name FROM products p LEFT JOIN order_items oi ON oi.product_id = p.id
-- WHERE oi.id = NULL;
-- Dự đoán số dòng; giải thích UNKNOWN trong SQL và viết điều kiện đúng.

-- TODO 3: GROUP BY sai. Mục tiêu: mỗi user_id có một dòng đếm số đơn.
-- Query sai:
-- SELECT user_id, id, COUNT(*) FROM orders GROUP BY user_id;
-- Giải thích id nào có thể đại diện nhóm; sửa đúng yêu cầu, không chỉ làm hết lỗi cú pháp.

-- TODO 4: UPDATE thiếu WHERE. Mục tiêu: giảm stock sản phẩm 1 đúng 1 đơn vị nếu còn hàng.
-- Query sai:
-- UPDATE products SET stock = stock - 1;
-- Giải thích phạm vi tác động và vì sao CHECK stock >= 0 không thay cho WHERE.
-- Viết bản sửa trong BEGIN/ROLLBACK, dùng RETURNING, kiểm tra số dòng thực sự đổi.
-- Nếu không có dòng đổi, backend cần hiểu khả năng hết hàng hoặc id không tồn tại.

-- TODO 5: DELETE nguy hiểm. Mục tiêu: xóa đúng một đơn cancelled và các dòng hàng của nó.
-- Query sai:
-- DELETE FROM orders;
-- Giải thích phạm vi tác động; ON DELETE CASCADE khác RESTRICT ra sao?
-- Tra schema thực tế và giải thích vì sao không dựa vào FK để tránh xóa nhầm.
-- Chọn id nhỏ nhất của orders cancelled; SELECT xem trước; xóa con rồi cha theo cùng id.
-- Thử bản sửa trong BEGIN/ROLLBACK và giải thích vì sao thao tác phải cùng transaction.

-- TODO 6: Tổng tiền sai vì JOIN nhân dòng. Mục tiêu: tổng giá trị mọi đơn của từng user.
-- Query sai:
-- SELECT u.id, u.name, SUM(o.total) FROM users u
-- JOIN orders o ON o.user_id = u.id JOIN order_items oi ON oi.order_id = o.id
-- GROUP BY u.id, u.name;
-- Giải thích total của đơn 1 xuất hiện mấy lần và vì sao user chưa có đơn bị mất.
-- Viết câu sửa giữ mọi user, tổng bằng 0 khi chưa có đơn.
-- Giải thích vì sao SUM(DISTINCT o.total) vẫn sai nếu hai đơn thật có cùng total.
