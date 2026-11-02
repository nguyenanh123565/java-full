# Demo — Statement và SQL cố định

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'StatementDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\03-statement\demo\StatementDemo.java
java -cp "$build;$env:PGJDBC_JAR" StatementDemo
```



Quan sát: Statement gửi chuỗi SQL hoàn chỉnh tới database. Chuỗi Java không tự hiểu đâu là giá trị người dùng, đâu là từ khóa SQL.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
