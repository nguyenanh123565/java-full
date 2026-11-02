# Demo — ResultSet và ánh xạ object

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'ResultSetDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\05-result-set\demo\ResultSetDemo.java
java -cp "$build;$env:PGJDBC_JAR" ResultSetDemo
```



Quan sát: Con trỏ ban đầu đứng trước hàng đầu tiên. next() trả true khi di chuyển đến một hàng hợp lệ. while(next()) duyệt nhiều hàng; if(next()) chỉ lấy nhiều nhất một hàng.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
