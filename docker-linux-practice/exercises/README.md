# Bài tổng hợp — lần theo một request trong hai container

Điều kiện: giải thích được Java process, URL HTTP, JDBC và SELECT count(*). Dùng [demo](../docker/java-postgresql-demo/README.md), không dùng DB thật.

- TODO: **Dự đoán trước khi chạy:** vẽ request host 8081 → app 8080 → db 5432; liệt kê output config/ps/log/curl mà bạn kỳ vọng.
- TODO: Trên bản copy riêng, đổi host port thành 8082; giữ internal port và JDBC URL đúng. Ghi command request mới.
- TODO: Qua psql thêm một product giả, đọc count bằng SQL rồi bằng HTTP; restart service, đối chiếu row còn.
- TODO: **Vì sao:** app container dùng db chứ không localhost? Vì sao volume không phải backup? Vì sao Started khác container running?
- TODO: **Liên hệ kiến thức cũ:** chỉ rõ chỗ Java object được tạo, SQL query gửi đi, HTTP status/body trả về; so với Product CLI JDBC đã học.
- TODO: Viết bảng ít nhất 3 lỗi giả định: sai host port, sai JDBC hostname, sai table. Với mỗi lỗi nêu nơi cần đọc trước và bằng chứng mong đợi.
- TODO: Ghi điều đã kiểm tra thực tế và điều chưa chạy; không ghi “pass” nếu mới đọc cấu hình.

Không cần phá cấu hình DB có dữ liệu, xóa volume hoặc cài công cụ mới để hoàn thành bài. [Định hướng giải](../solutions/README.md) nằm riêng.
