# Đối chiếu — Transaction, persistence context và dirty checking

Spring proxy mở transaction khi CLI gọi service bean. RuntimeException làm rollback. Một method tự gọi method @Transactional cùng instance không đi qua proxy. readOnly là hint/optimization, không thay quyền database.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
