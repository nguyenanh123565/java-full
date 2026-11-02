# Console reference — JPA Product/Category

Lời giải tham khảo sau khi tự làm starter. App console nhỏ có CRUD, relation, rollback, dirty checking và hai fetch plan. Chỉ Java 17, Boot 3.5.16, data-jpa, pg driver. Không có web/security/UI.

## Chuẩn bị thủ công khi bạn sẵn sàng

1. Tạo database học **mới** `learning_backend_jpa` và user học riêng bằng kiến thức SQL đã học; không sử dụng database cũ.
2. Đọc [schema.sql](schema.sql), kiểm tra `current_database()`, rồi tự chạy trong database mới. Không chạy trên workspace/database SQL hay JDBC cũ.
3. Set biến môi trường PowerShell, không ghi mật khẩu vào source:

```powershell
$env:JPA_JDBC_URL = 'jdbc:postgresql://localhost:5432/learning_backend_jpa'
$env:JPA_JDBC_USER = 'learning_user'
$env:JPA_JDBC_PASSWORD = '<mật khẩu học riêng>'
```

`ddl-auto=validate` kiểm tra schema; app không tạo database/schema/tables. Chưa có dependency nào được cài/tải hoặc database nào được setup khi tạo workspace. Các lệnh dưới đây chỉ dành cho lúc bạn chủ động học: Maven có thể tải dependency/plugin vào local repository.

## Chạy (PowerShell, từ thư mục chứa pom.xml này)

```powershell
mvn package -DskipTests
java -jar .\target\jpa-catalog-lab-1.0.0.jar add-category 'Books'
# Thay <categoryId> ở ví dụ bên dưới bằng số id thực tế in ra; không gõ dấu <>.
java -jar .\target\jpa-catalog-lab-1.0.0.jar add 'Java Notebook' 120.50 3 1
java -jar .\target\jpa-catalog-lab-1.0.0.jar list
java -jar .\target\jpa-catalog-lab-1.0.0.jar find 1
java -jar .\target\jpa-catalog-lab-1.0.0.jar update 1 'Updated Notebook' 130.00 4
java -jar .\target\jpa-catalog-lab-1.0.0.jar delete 1
```

Các số 1 chỉ là ví dụ: thay bằng id add-category/add trả về, không giả định id liên tiếp. `add name price stock` bỏ categoryId tạo product không có category. `update` thay name/price/stock và giữ category hiện tại. `list` rỗng không in ProductView; query log vẫn cho thấy SELECT.

## Quan sát transaction và N+1

```powershell
java -jar .\target\jpa-catalog-lab-1.0.0.jar fail-add
java -jar .\target\jpa-catalog-lab-1.0.0.jar list
java -jar .\target\jpa-catalog-lab-1.0.0.jar list-details
```

fail-add cố ý ném IllegalStateException trong service transaction; runner bắt lỗi **sau khi proxy rollback**. Kiểm chứng SQL `SELECT count(*) FROM learning_jpa.products WHERE name = 'ROLLBACK-DEMO';` cho 0 nếu bạn chưa tự tạo tên này trước đó. SQL INSERT xuất hiện không có nghĩa đã commit.

Để đo N+1: tạo ít nhất ba category khác nhau, rồi ba product mỗi cái một category. `list` dùng lazy category và đọc categoryName trong DTO mapping → có thể 1 SELECT products + 3 SELECT categories. `list-details` dùng left join fetch → 1 SELECT dữ liệu, vẫn giữ product category null. Mỗi lệnh là process mới nên persistence context không được tái sử dụng từ lệnh trước; bỏ SQL metadata/schema validation khi đếm. Nếu category dùng chung, first-level cache giảm số query phụ.

## Điều cần giải thích sau khi chạy

- Product.category sở hữu category_id; Category.products mappedBy="category".
- Entity constructor no-arg phục vụ JPA; public constructor giữ input hợp lệ.
- updateDetails trên managed entity phát UPDATE nhờ dirty checking; không gọi save lần nữa.
- Service giữ @Transactional; CLI không đọc entity lazy bên ngoài service, chỉ nhận ProductView.
- Không cascade REMOVE sang Category dùng chung; xóa Product không xóa Category.
- Spring Data repository → JPA → Hibernate → JDBC → PostgreSQL vẫn cùng luồng JDBC đã học.

Giới hạn: console reference không có pagination, concurrent stock update, web endpoint hay all relationship demos. One-to-one/many-to-many/cascade OrderItem ở lesson là extension có ngữ cảnh; chỉ áp dụng vào bản sao và schema học riêng khi bạn tự thiết kế đủ DDL. Maven build/DB runtime chưa được thực hiện tự động trong phiên tạo workspace.
