# Demo — đọc recipe có hai thời điểm

Đọc [Dockerfile](../../java-postgresql-demo/Dockerfile), [.dockerignore](../../java-postgresql-demo/.dockerignore) và [POM](../../java-postgresql-demo/pom.xml).

Trước khi tự build, đánh dấu: FROM/COPY/RUN thuộc tạo image; ENTRYPOINT thuộc khởi động container. Chỉ JAR được copy sang runtime. `docker compose build app` sẽ tải/build nếu thiếu cache, vì vậy không chạy tự động trong workspace học.
