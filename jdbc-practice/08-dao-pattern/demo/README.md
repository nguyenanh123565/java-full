# Demo — DAO pattern cơ bản

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'DaoDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\08-dao-pattern\demo\DaoDemo.java
java -cp "$build;$env:PGJDBC_JAR" DaoDemo
```



Quan sát: DAO đóng gói truy cập dữ liệu và mapping. Caller làm việc với Product, Optional và List. Service giữ quy tắc nghiệp vụ; CLI chỉ nhập/xuất. Pattern này là Java thông thường, không cần framework.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
