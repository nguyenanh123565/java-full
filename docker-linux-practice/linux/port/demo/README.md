# Demo — quan sát trước request

Trên Linux nếu đã có `ss`:

```bash
ss -ltn
```

Không cài thêm để hoàn thành bài. Khi [Compose demo](../../../docker/java-postgresql-demo/README.md) đã chạy:

```bash
curl -i http://localhost:8081/products/count
```

Ghi dự đoán: chưa chạy app thì lỗi transport, chạy app nhưng route sai thì HTTP 404. Không cần publish PostgreSQL lên host để app trong cùng Compose kết nối DB.
