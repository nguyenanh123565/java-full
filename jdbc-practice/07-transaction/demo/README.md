# Demo — Transaction, commit và rollback

Đây là Java chạy được, cần PostgreSQL và driver khi chạy; đọc README workspace để tự chuẩn bị môi trường học riêng. Dự đoán kết quả trước khi chạy. Không chạy trên database cũ.

Từ `E:\JAVA_FULL\jdbc-practice` trong PowerShell:

```powershell
$build = Join-Path $env:TEMP 'TransactionDemo-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\demo-support\JdbcSupport.java .\demo-support\JdbcProduct.java .\07-transaction\demo\TransactionDemo.java
java -cp "$build;$env:PGJDBC_JAR" TransactionDemo
```



Quan sát: Một Connection với autoCommit=false gom câu lệnh vào transaction. commit xác nhận toàn bộ; rollback hủy thay đổi chưa commit. Phải dùng cùng Connection cho các bước thuộc cùng transaction.

TODO: ghi dữ liệu đầu vào, output và một câu SQL kiểm chứng vào notes. Với bảng rỗng, demo danh sách không in Product nào; điều đó không phải lỗi.
