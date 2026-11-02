# Đối chiếu — Sinh ID và identity

ID duy nhất là yêu cầu, liên tiếp không phải yêu cầu. Identity có thể cần insert để biết id; transaction vẫn có thể rollback hàng đó. Sequence không nhất thiết lùi khi rollback.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
