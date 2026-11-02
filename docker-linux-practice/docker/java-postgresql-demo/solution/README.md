# Đối chiếu sau lần tự làm

Reference runnable nằm ở thư mục cha, có compose.yaml, Dockerfile, POM và source; [README](../README.md) ghi cách chạy. Thư mục này giải thích kết quả, không là project chạy khác.

Host gọi 127.0.0.1:8081; app nhận ở 8080. App gọi hostname Compose db ở 5432; DB không publish ra host nên không có localhost:5432 dành riêng cho demo này. EXPOSE trong Dockerfile mô tả port, còn ports của Compose mới publish nó.

Ví dụ thêm một row, chỉ khi đã tự làm và database demo đang chạy:

```powershell
docker compose exec db psql -U learner -d learning_backend -c "INSERT INTO products(name, price) VALUES ('Pencil', 3.50);"
```

Nếu ban đầu chỉ có hai row seed, thêm thành công một row thì count từ 2 thành 3. COUNT(*) đếm row, không cộng price và không phụ thuộc id liên tục. Table rỗng có count 0, không phải missing resource 404.

`down` gỡ container/network nhưng giữ named volume; up sau đó vẫn thấy row đã thêm. Dockerfile rebuild thay image app, không thay nội dung volume PostgreSQL. Init script chỉ chạy khi PGDATA trống ở lần khởi tạo nên sửa file seed không làm count của database hiện hữu đổi. Muốn thêm dữ liệu học vào database đã có, dùng SQL rõ ràng; không dùng xóa volume làm bước sửa thường lệ.

Service giúp ranh giới use case rõ dù bài này chỉ chuyển tiếp; repository giữ SQL và JDBC. Không thêm transaction annotation vì một SELECT COUNT(*) không cần transaction nhiều thao tác do ứng dụng điều phối. Request path sai thường không tới service; lỗi kết nối xảy ra khi repository cần DB và được ghi log server. Healthcheck startup không ngăn DB hỏng sau đó.

Kiểm tra cấu trúc XML/Compose chỉ xác nhận tệp hợp lệ; không chứng minh image build hoặc HTTP/DB runtime. Phiên tạo workspace không chạy build/up/pull hay setup dependency.
