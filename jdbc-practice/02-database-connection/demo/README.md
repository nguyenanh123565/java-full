# Demo — Connection và DriverManager

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'ConnectionDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\02-database-connection\demo\ConnectionDemo.java
java -cp "$build;$env:PGJDBC_JAR" ConnectionDemo
```



Quan sát: DriverManager chọn driver từ JDBC URL, driver mở phiên kết nối, Connection đại diện cho phiên đó. URL, user và password là cấu hình; không đưa mật khẩu thật vào source hoặc Git.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
