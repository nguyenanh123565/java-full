# Đối chiếu — JPA, Hibernate và Spring Data JPA

Bạn có thể dùng JPA EntityManager mà không dùng Spring Data JPA. Trong reference, starter-data-jpa cung cấp tích hợp Spring Data + Hibernate. PostgreSQL driver vẫn cần ở runtime.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
