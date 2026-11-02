# Demo — JDBC overview

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'JdbcOverviewDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\01-jdbc-overview\demo\JdbcOverviewDemo.java
java -cp "$build;$env:PGJDBC_JAR" JdbcOverviewDemo
```



Quan sát: Java → JDBC API → PostgreSQL Driver → PostgreSQL → ResultSet → Java Object. JDBC API là các interface trong java.sql; driver là bản triển khai nói giao thức PostgreSQL. Database thực thi SQL, driver chuyển dữ liệu qua kết nối.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
