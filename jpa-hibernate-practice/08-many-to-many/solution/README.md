# Đối chiếu — Many-to-many và join table

Bảng nối lưu quan hệ. Cascade REMOVE sang tag chung có thể phá dữ liệu dùng chung nên không dùng tùy tiện. OrderItem có quantity/price nên thường là entity riêng, không phải @ManyToMany thuần.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
