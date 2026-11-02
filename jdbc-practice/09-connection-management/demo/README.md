# Demo — Vòng đời tài nguyên JDBC

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'ResourcesDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\09-connection-management\demo\ResourcesDemo.java
java -cp "$build;$env:PGJDBC_JAR" ResourcesDemo
```



Quan sát: try-with-resources đóng theo thứ tự ngược: ResultSet → Statement → Connection, kể cả khi có exception. Đóng Connection đang có transaction chưa xong không thay cho commit/rollback rõ ràng.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
