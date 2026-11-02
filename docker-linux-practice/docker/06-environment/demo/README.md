# Demo — đọc từ hai phía

Mở [compose.yaml](../../java-postgresql-demo/compose.yaml). Dùng bút nối POSTGRES_DB với phần path trong JDBC URL; nối username/password hai phía.

`docker compose config` render cấu hình nhưng có thể in giá trị env, nên chỉ dùng bản demo giả và không đưa output chứa secret thật vào báo cáo. Không có file .env thật hay credential cá nhân nào được tạo.
