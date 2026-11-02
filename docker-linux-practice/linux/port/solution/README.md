# Đối chiếu — Port: địa chỉ dịch vụ trên một host

Host dùng 8081 theo mapping;8080 là port app bên trong container. Connection refused xảy ra trước HTTP routing;404 là đã nhận response từ server. App container dùng db:5432 vì db là service DNS nội bộ. localhost luôn là môi trường mạng của bên gọi, không tự trỏ container khác.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
