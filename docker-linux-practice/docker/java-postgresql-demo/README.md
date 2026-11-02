# Demo tổng hợp — Spring Boot + JDBC + PostgreSQL + Docker Compose

Học sau các bài Linux process/port/environment/logs, Docker image/container/volume/Compose, Maven, JDBC và Spring MVC. Đây là ứng dụng nhỏ chạy được, chỉ có `GET /products/count`; không thêm JPA, Security hoặc UI.

## 1. Problem

App Java và database là hai process có môi trường khác nhau. Compose mô tả cách tạo chúng, nối mạng nội bộ và giữ dữ liệu qua vòng đời container. Mục tiêu là tự giải thích request tới SQL chứ không chỉ thấy container màu xanh.

## 2. Mental model

```text
Client trên máy host
→ GET http://127.0.0.1:8081/products/count
→ Docker port mapping host 8081 → container app 8080
→ Spring Controller → Service → Repository/JdbcTemplate
→ JDBC driver → db:5432/learning_backend
→ PostgreSQL: SELECT COUNT(*) FROM products
→ Long Java → record CountResponse → JSON {"count":2}
```

`app` và `db` là service trên mạng mặc định của Compose. Từ app, hostname `db` trỏ tới container PostgreSQL; `localhost` trong app là chính container app. PostgreSQL không publish port ra host. Port 8081 chỉ bind loopback 127.0.0.1; từ máy này dùng URL bên trên, không gọi `http://db:5432` như HTTP API.

## 3. Ví dụ nhỏ và cách chạy khi chủ động thực hành

Source/POM/Dockerfile/Compose trong thư mục này là reference hoàn chỉnh. Dockerfile dùng build stage Maven 3.9 + JDK 17 để package, rồi runtime stage Temurin 17 JRE chỉ chạy executable jar. Boot Maven plugin đóng gói dependency vào jar. Không cần Maven cài trên host để build bằng Docker; cần Docker Desktop/Engine và Compose hoạt động.

Mở PowerShell tại thư mục chứa compose.yaml này:

```powershell
docker compose config
docker compose up --build -d
docker compose logs -f app db
```

`config` parse/render cấu hình; chưa tạo container. `up --build -d` build app, có thể tải base image/dependency và khởi động nền; chỉ chạy khi bạn sẵn sàng. `logs -f` theo dõi stdout/stderr; Ctrl+C dừng theo dõi log. Sau khi app báo started, ở terminal khác:

```powershell
Invoke-RestMethod http://127.0.0.1:8081/products/count
# Hoặc xem status/header/body:
curl.exe -i http://127.0.0.1:8081/products/count
```

Với volume mới chưa sửa dữ liệu: HTTP 200, JSON `{"count":2}`. Muốn dừng và gỡ container/network của demo:

```powershell
docker compose down
```

Named volume `pg_data` vẫn còn, tên thực thường có prefix tên project Compose. Lần up sau tái sử dụng dữ liệu. Không dùng tùy chọn `-v` trong quy trình học thông thường vì tùy chọn đó xóa named volume. Các lệnh này chỉ là hướng dẫn; trong phiên tạo workspace chưa build/up/pull image hoặc tải dependency.

## 4. Liên hệ Java Core, HTTP, SQL và cấu hình

- Java Core: constructor injection nối Controller → Service → Repository → JdbcTemplate; record là object response.
- HTTP: route GET đọc dữ liệu, không làm INSERT; response là JSON. Số row database không phải số byte HTTP.
- JDBC/SQL: JdbcTemplate quản lý boilerplate connection/statement/result mapping, driver PostgreSQL vẫn giao tiếp database. COUNT(*) trả một giá trị BIGINT, ánh xạ Long; query cố định không có dữ liệu client để nối chuỗi.
- Maven: chỉ web, jdbc và driver runtime; chưa cần ORM. Spring Boot 3.5.16/Java17 là baseline học thống nhất của workspace, không khẳng định là bản mới nhất.
- Environment: app đọc JDBC_URL/USER/PASSWORD từ Compose; URL app là `jdbc:postgresql://db:5432/learning_backend`. Đây là kết nối database, khác URL HTTP trên host.

`POSTGRES_DB`, `POSTGRES_USER`, `POSTGRES_PASSWORD` khởi tạo database/user **khi thư mục dữ liệu trống**. `db/init/01-products.sql` được mount read-only vào docker-entrypoint-initdb.d và chạy ở lần khởi tạo đó, tạo table và hai row mẫu. Sửa file init hoặc đổi biến POSTGRES_PASSWORD không tự sửa database đã tồn tại trong volume. Password `learning_only` là chuỗi giả cho demo riêng này; không dùng lại mật khẩu tài khoản thật.

`depends_on: condition: service_healthy` đợi healthcheck database trước khi start app. `pg_isready -h 127.0.0.1` kiểm PostgreSQL lắng nghe TCP trong container db; app vẫn phải có cơ chế xử lý lỗi nếu DB ngừng sau startup. Healthcheck không phải bằng chứng mọi query/schema đều đúng. `spring.sql.init.mode=never` để Spring không chạy thêm schema; init do PostgreSQL container thực hiện một lần.

## 5. Lỗi thường gặp

App dùng localhost thay db; dùng host port 8081 để gọi JDBC; quên database init chỉ chạy với volume trống; nghĩ docker compose down đã xóa row; sửa source mà không rebuild; nghĩ EXPOSE tự publish port. Nếu request lỗi, xem logs app/db và tách lỗi HTTP mapping, lỗi kết nối, lỗi SQL thay vì thêm dependency tùy ý.

## 6. Câu hỏi tự kiểm tra

Vì sao app dùng db:5432 nhưng browser dùng 127.0.0.1:8081? SQL nằm ở lớp nào? COUNT(*) rỗng trả gì? Xóa container khác xóa volume ra sao? Vì sao thay file seed không làm count đổi trên volume cũ?

## 7. Exercise và đối chiếu

Đọc [demo trace](demo/README.md), tự làm [exercise](exercise/README.md) và ghi [notes](notes.md), rồi mới xem [solution](solution/README.md). Các bài thay đổi làm trên bản sao hoặc chính demo mới này; không kết nối tới database/workspace SQL cũ.

## Annotation trong source giải quyết gì?

| Annotation | Công việc được hỗ trợ | Java thủ công tương đương | Quan hệ HTTP |
|---|---|---|---|
| @SpringBootApplication | Cấu hình, quét component từ learn.compose, auto-configuration | Tạo server, DataSource và object graph | Khởi động hạ tầng, chưa tạo route |
| @RestController | Đăng ký HTTP adapter và ghi kết quả vào response body | Handler tự serialize JSON | Trả record thành JSON |
| @GetMapping | Chọn method Java theo GET + path | So method/path rồi dispatch | GET /products/count |
| @Service | Đăng ký object vai trò use case | new service(repository) | Controller gọi sau dispatch; không tự tạo route |
| @Repository | Đăng ký object tầng dữ liệu | new repository(jdbc) | SQL không thuộc controller/status |

JdbcTemplate và record là kiểu Java, không phải annotation. Constructor duy nhất không cần @Autowired. Tham khảo [Spring annotation map](../../../spring-boot-practice/annotation-map.md), [JDBC](../../../jdbc-practice/README.md) và [Docker Compose overview](https://docs.docker.com/compose/).
