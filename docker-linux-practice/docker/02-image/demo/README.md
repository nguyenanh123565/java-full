# Demo — đọc image thay vì tải ngay

Mở [Dockerfile](../../java-postgresql-demo/Dockerfile). Stage build dùng `maven:3.9-eclipse-temurin-17`, stage runtime dùng `eclipse-temurin:17-jre`; DB dùng `postgres:17` trong Compose.

Không cần pull để hiểu vai trò. Khi đã có image từ lần chạy demo, `docker compose images` tại demo cho biết image service đang dùng. Ghi image ID/tag và phân biệt chúng với container ID từ `docker compose ps`.
