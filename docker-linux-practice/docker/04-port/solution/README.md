# Đối chiếu — Port mapping: host 8081 → container 8080

Host đổi sang 8082 nên curl cũng đổi 8082; server vẫn nghe 8080 trong app. DB được service DNS db phân giải ở mạng Compose, app dùng db:5432. Không publish DB vẫn cho phép service cùng network kết nối. Host không tự có DNS db từ Compose.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
