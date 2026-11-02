# Đối chiếu — Vấn đề ORM giải quyết

ORM giảm code mapping chứ không xóa quan hệ bảng/cột. JDBC vẫn nằm dưới Hibernate. Object mới tạo bằng new chưa được quản lý cho tới persist/save; object detached sửa field không tự dirty-check.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
