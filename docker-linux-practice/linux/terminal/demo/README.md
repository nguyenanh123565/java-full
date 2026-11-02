# Demo — đọc output đúng lớp

Các command Bash căn bản, không cài gì:

```bash
pwd
ls -la
```

Khi bạn đã tự khởi động [Compose demo](../../../docker/java-postgresql-demo/README.md):

```bash
curl -i http://localhost:8081/products/count
curl -i http://localhost:8081/route-does-not-exist
curl --fail-with-body -i http://localhost:8081/route-does-not-exist
```

Viết dự đoán trước: command nào có HTTP response, command nào trả exit code khác 0? Đọc exit code ngay sau command qua `printf '%s\n' "$?"` trong Bash. Không chạy command setup để học phần đọc này.
