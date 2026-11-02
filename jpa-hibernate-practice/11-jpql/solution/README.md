# Đối chiếu — JPQL và entity query

JPQL dựa entity/field, SQL dựa table/column. Parameter giữ giá trị tách khỏi cú pháp nhưng không thay thế được entity name. JOIN thường chỉ phục vụ điều kiện; JOIN FETCH còn khởi tạo quan hệ.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
