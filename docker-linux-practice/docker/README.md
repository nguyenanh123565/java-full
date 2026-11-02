# Docker — thứ tự học cho Java Backend

Điều kiện: [Linux nền tảng](../linux/README.md), hiểu Java process, HTTP port, JDBC URL và SQL. Chưa cần chạy container khi chưa phân biệt image/container/volume.

1. [01-container-concept](01-container-concept/README.md): process và môi trường tách biệt.
2. [02-image](02-image/README.md): template/layer/tag và runtime.
3. [03-dockerfile](03-dockerfile/README.md): build-time khác runtime.
4. [04-port](04-port/README.md): host 8081 → app 8080, app → db 5432.
5. [05-volume](05-volume/README.md): vòng đời dữ liệu DB.
6. [06-environment](06-environment/README.md): cấu hình app và DB initialize.
7. [07-docker-compose](07-docker-compose/README.md): ghép hai service, healthcheck và startup.
8. [java-postgresql-demo](java-postgresql-demo/README.md): Spring JDBC + PostgreSQL + Compose nhỏ.

Mỗi lesson có demo/exercise/solution/notes riêng. Chưa có bước setup tự động; build image có thể tải image và dependency khi bạn tự chọn chạy. Demo dùng dữ liệu giả; không có lệnh xóa volume.

Sẵn sàng làm [bài tổng hợp](../exercises/README.md) khi lần theo được HTTP → controller → JDBC → SQL và dùng log để phân biệt lỗi port, cấu hình hay schema. Ghi [notes](../notes.md), ghi rõ điều đã chạy thực tế và điều mới dự đoán.
