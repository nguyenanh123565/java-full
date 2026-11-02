# Đối chiếu — One-to-many và many-to-one

category_id nằm ở products, nên Product.category là owning side. List Category.products không tự biến thành cột array trong SQL. Khi chuyển quan hệ, cần giữ cả phía cũ và mới trong memory nhất quán.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
