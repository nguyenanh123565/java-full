# Docker / Linux — môi trường chạy Java Backend

Học sau Java + HTTP + SQL + Spring Boot và các bài testing nền tảng. Đọc ngay mental model nếu tò mò; chưa cần vận hành container khi chưa hiểu process Java, port HTTP và PostgreSQL là server riêng. Chỉ học kiến thức junior dùng hằng ngày, không làm Linux sysadmin.

Mục tiêu: giải thích được app nằm ở đâu, process nào chạy, cổng nào nghe, cấu hình lấy ở đâu, log cho biết gì và dữ liệu DB nằm đâu. Container chia sẻ kernel của môi trường Linux; trên Docker Desktop môi trường đó thường là VM/WSL 2, không phải JVM thay thế.

Học lần lượt Linux:

1. [filesystem](linux/filesystem/README.md)
2. [terminal](linux/terminal/README.md)
3. [process](linux/process/README.md)
4. [port](linux/port/README.md)
5. [environment-variable](linux/environment-variable/README.md)
6. [logs](linux/logs/README.md)

Rồi Docker:

1. [01-container-concept](docker/01-container-concept/README.md)
2. [02-image](docker/02-image/README.md)
3. [03-dockerfile](docker/03-dockerfile/README.md)
4. [04-port](docker/04-port/README.md)
5. [05-volume](docker/05-volume/README.md)
6. [06-environment](docker/06-environment/README.md)
7. [07-docker-compose](docker/07-docker-compose/README.md)
8. [java-postgresql-demo](docker/java-postgresql-demo/README.md) — app Spring JDBC nhỏ, không JPA, có Dockerfile/Compose/source.

Các bài Linux dùng Bash, không dán nguyên lệnh Bash vào PowerShell. Command Docker dùng tại thư mục chứa compose.yaml. Đọc [bài tổng hợp](exercises/README.md), tự ghi notes từng bài và [notes workspace](notes.md).

Sẵn sàng chuyển sang backend project khi tự lần theo `curl → host port → container port → controller → JDBC → db:5432`, đọc log để phân biệt lỗi port/credentials/schema và chứng minh dữ liệu còn sau restart. Không có lệnh prune hoặc xóa volume trong bài học.

Demo dùng Java 17, Spring Boot 3.5.16 làm mốc học, PostgreSQL 17; không tuyên bố đây là version mới nhất. Không cài/tải dependency hay khởi động Docker trong quá trình tạo workspace. Khi tự build image lần đầu, Docker/Maven sẽ cần tải image/plugin/dependency nếu cache chưa có.

Tham khảo chính thức: [Compose startup order](https://docs.docker.com/compose/how-tos/startup-order/), [Docker volumes](https://docs.docker.com/engine/storage/volumes/), [Spring Boot 3.5 requirements](https://docs.spring.io/spring-boot/3.5/system-requirements.html).
