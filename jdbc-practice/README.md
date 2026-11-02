# JDBC — cầu nối Java với PostgreSQL

Học sau Java Core + HTTP + SQL, trước JPA/Hibernate. Mục tiêu là tự giải thích được đường đi của dữ liệu, không chỉ chạy CRUD.

```text
Java
 → JDBC API (java.sql: Connection, PreparedStatement, ResultSet)
 → PostgreSQL Driver (implementation, pgJDBC jar lúc chạy)
 → PostgreSQL (thực thi SQL, lưu dữ liệu)
 → ResultSet (con trỏ hàng/cột)
 → Java Object (code mapping do bạn viết)
```

JDK cung cấp API JDBC; pgJDBC nói giao thức PostgreSQL. Đây không phải HTTP. Object Java không tự lưu xuống database khi sửa field.

## Thứ tự học
1. [JDBC overview](01-jdbc-overview/README.md)
2. [Connection và DriverManager](02-database-connection/README.md)
3. [Statement và SQL cố định](03-statement/README.md)
4. [PreparedStatement và SQL parameter](04-prepared-statement/README.md)
5. [ResultSet và ánh xạ object](05-result-set/README.md)
6. [CRUD bằng JDBC](06-crud/README.md)
7. [Transaction, commit và rollback](07-transaction/README.md)
8. [DAO pattern cơ bản](08-dao-pattern/README.md)
9. [Vòng đời tài nguyên JDBC](09-connection-management/README.md)

Sau bài 09: [bài tổng hợp](exercises/README.md) → [Product Management CLI](mini-project/README.md). [Solutions](solutions/README.md) chỉ mở sau khi làm.

## Cách dùng demo (PowerShell / Java 17+)

Các demo chỉ import JDK `java.sql`; javac không cần driver. Chưa cài thêm gì và chưa kết nối database khi tạo workspace này. Khi bạn sẵn sàng, dùng một database học mới tên `learning_backend_jdbc`, user học riêng chỉ có quyền trong database đó. Không chạy schema hoặc demo trên database/bài SQL cũ.

1. Tự tạo database học bằng công cụ PostgreSQL bạn đã biết. Xem `current_database()` trước khi chạy SQL.
2. Mở [schema.sql](demo-support/schema.sql), đọc và thực thi thủ công trong database mới. Script chỉ tạo schema `learning_jdbc` cùng hai bảng học; không chứa lệnh reset/drop.
3. Chuẩn bị pgJDBC jar từ nguồn chính thức khi cần. README không tải/cài driver, không dùng Maven/Spring/JPA.
4. Đặt biến môi trường trong phiên PowerShell; không lưu mật khẩu thật trong repository:

```powershell
# Chạy tại E:\JAVA_FULL\jdbc-practice; thay đường dẫn jar bằng file bạn đã có.
$env:PGJDBC_JAR = 'C:\learning-tools\postgresql-driver.jar'
$env:JDBC_URL = 'jdbc:postgresql://localhost:5432/learning_backend_jdbc'
$env:JDBC_USER = 'learning_user'
$env:JDBC_PASSWORD = '<nhập mật khẩu học riêng>'
$build = Join-Path $env:TEMP 'jdbc-overview-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .-jdbc-overview\demo\JdbcOverviewDemo.java
java -cp "$build;$env:PGJDBC_JAR" JdbcOverviewDemo
```

Classpath Windows phân cách bằng `;`, và cần đặt cả chuỗi trong dấu nháy. Chỉ chạy demo khi URL/user trỏ đến môi trường học mới. Không hard-code credential; không commit secret. Nếu thiếu driver lúc chạy, có thể gặp `No suitable driver found`; không cần `Class.forName` với driver hiện đại đúng classpath.

Mỗi lesson có demo, exercise TODO, solution đối chiếu và notes cá nhân. Demo 06 thêm/sửa/xóa một hàng thử; demo 07 tạo dữ liệu rồi rollback có chủ đích. Các demo khác chủ yếu SELECT. SQL của demo luôn dùng schema `learning_jdbc`.

## Tự kiểm tra trước khi học Maven

- Giải thích được ai thực thi SQL, ai duyệt ResultSet, ai tạo Product.
- Bind được giá trị và biết vì sao identifier cần whitelist.
- Dùng try-with-resources; mô phỏng rollback đúng trên cùng Connection.
- Hoàn thành CLI add/list/find/update/delete và phân biệt lỗi DB với không có dữ liệu.

Tài liệu chính thức: [JDBC basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/), [pgJDBC usage](https://jdbc.postgresql.org/documentation/use/), [PostgreSQL transactions](https://www.postgresql.org/docs/current/tutorial-transactions.html). Không cần học pool hay ORM ở giai đoạn này.
