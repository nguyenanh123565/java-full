# Demo Bash — file tạm và log container

```bash
LAB=$(mktemp -d)
printf '10:00 INFO app starting\n 10:01 ERROR DB connection refused\n' > "$LAB/app.log"
tail -n 10 "$LAB/app.log"
```

Nếu Compose demo đã chạy, tại thư mục chứa compose.yaml:

```text
docker compose logs --tail 30 app
docker compose logs --tail 30 db
```

Không copy password/token vào notes. Viết dự đoán lỗi thuộc network, HTTP route hay SQL trước khi đọc giải thích.
