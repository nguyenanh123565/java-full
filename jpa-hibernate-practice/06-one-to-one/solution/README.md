# Đối chiếu — Quan hệ one-to-one và owning side

mappedBy trỏ tới field product trong ProductDetail. Database phải có UNIQUE(product_id) ngoài FK để có one-to-one. Đồng bộ hai phía object giúp memory nhất quán; owning side quyết định FK.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
