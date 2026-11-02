# Demo — quan sát persistence

Đọc volumes ở [compose.yaml](../../java-postgresql-demo/compose.yaml). PostgreSQL image 17 dùng `/var/lib/postgresql/data`; không đổi sang mount path của major image khác.

Sau khi demo đã chạy, ghi count, insert một product giả qua psql, rồi `docker compose restart db app`; đợi DB/app sẵn sàng và đọc count lại. Restart cùng container chứng minh không mất dữ liệu khi dừng/start; named volume còn cho phép recreate container vẫn giữ dữ liệu. Không cần xóa/tạo lại volume để học.
