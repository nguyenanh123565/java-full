# Demo — bản ghép nhỏ, có thể chạy khi đã sẵn môi trường

Đọc [java-postgresql-demo](../../java-postgresql-demo/README.md). Tại thư mục demo, `docker compose config --quiet` kiểm tra parse/validation mà không start service. `docker compose up --build -d` mới tải/build/start khi bạn chủ động chọn thực hành.

Đợi `docker compose logs --tail 30 app` có Started, rồi curl. `docker compose ps` cho trạng thái container; HTTP smoke request xác nhận app phục vụ thực tế. `docker compose stop` dừng để nghỉ mà giữ dữ liệu.
