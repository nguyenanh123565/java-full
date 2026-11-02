# Đối chiếu — Cascade và vòng đời entity

Cascade chọn theo ownership nghiệp vụ, không theo sự tiện gõ code. PERSIST khác REMOVE, fetch khác cascade. orphanRemoval xử lý child phụ thuộc bị bỏ khỏi quan hệ khi managed; database FK vẫn có thể từ chối thao tác.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
