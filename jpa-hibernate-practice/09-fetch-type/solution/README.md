# Đối chiếu — Fetch type và thời điểm đọc dữ liệu

Fetch type là chiến lược mặc định, fetch join/query quyết định dữ liệu cần cho một use case cụ thể. DTO mapping trong transaction giúp chủ động dữ liệu. EAGER không phải cách sửa N+1 tổng quát.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
