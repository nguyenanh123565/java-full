# Đối chiếu — Native SQL trong repository

Native SQL dùng tên bảng/cột và cú pháp PostgreSQL. Parameter binding vẫn áp dụng cho giá trị. Với query chỉnh sửa bulk cần @Modifying/transaction và phải hiểu persistence context có thể cũ; chưa cần dùng trong CRUD beginner.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
