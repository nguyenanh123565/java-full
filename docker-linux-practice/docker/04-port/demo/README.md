# Demo — hai loại địa chỉ

Mở [compose.yaml](../../java-postgresql-demo/compose.yaml), tìm ports và SPRING_DATASOURCE_URL. Khi demo đã chạy:

```text
curl -i http://localhost:8081/products/count
docker compose exec db psql -U learner -d learning_backend -c "SELECT count(*) FROM products;"
```

Không thử curl lên 5432: đó là PostgreSQL protocol. Port host bind 127.0.0.1 giữ demo chỉ truy cập trực tiếp từ máy học.
