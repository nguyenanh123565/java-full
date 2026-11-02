# Bài tập — Compose: mô tả app và DB cùng nhau

- TODO: Đọc Compose demo, vẽ startup order và runtime request flow; khi đã có Docker validate config rồi tự chạy nếu muốn thực hành.
- TODO: **Dự đoán trước khi chạy:** App được tạo trước hay sau khi DB healthcheck healthy? Endpoint count có sẵn ngay lúc container “running” không?
- TODO: **Vì sao:** Vì sao healthcheck và HTTP smoke request là hai bằng chứng khác nhau?
- TODO: **Liên hệ kiến thức cũ:** Theo một GET /products/count từ curl tới Java/JDBC/PostgreSQL rồi trở về JSON; ghi rõ lớp nào xử lý gì.
- TODO: ghi command, điều quan sát được và kết luận. Chỉ sửa bản copy/thư mục thử riêng; dùng dữ liệu giả.
