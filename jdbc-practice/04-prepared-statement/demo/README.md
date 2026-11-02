# Demo — PreparedStatement và SQL parameter

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'PreparedDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\04-prepared-statement\demo\PreparedDemo.java
java -cp "$build;$env:PGJDBC_JAR" PreparedDemo
```

Đối số tùy chọn: thêm một tên product ở cuối lệnh Java, ví dụ `"O'Reilly"`.

Quan sát: SQL là khuôn có dấu ?. setString/setBigDecimal gắn giá trị vào vị trí 1-based. Tham số bảo vệ giá trị trong query này; nó không đại diện được tên table, tên column, ASC hoặc DESC.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
