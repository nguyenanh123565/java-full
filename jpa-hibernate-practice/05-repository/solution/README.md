# Đối chiếu — Repository và truy cập dữ liệu

Spring Data tạo proxy thực thi repository contract. Không cần tự viết class ProductRepositoryImpl cho CRUD chuẩn. Service cần transaction khi nhiều repository call là một nghiệp vụ.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
