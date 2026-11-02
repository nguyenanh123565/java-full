# Đối chiếu — N+1 và fetch join có chủ đích

Với ba category riêng chưa được load, list có thể tạo 4 SELECT dữ liệu; fetch join list-details tạo 1 SELECT. Nếu category dùng chung thì first-level cache giảm query phụ. Đo SQL và số hàng thay vì đoán từ tên annotation.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
