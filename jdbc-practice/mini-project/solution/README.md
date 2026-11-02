# Reference Product Management CLI

Đây là một cách làm tối giản sau khi đã hoàn thành starter, không phải project production. CLI chỉ nhập/xuất và validation; DAO thực thi SQL + mapping; Database đọc env. Mỗi thao tác CRUD độc lập dùng auto-commit; bài chuyển stock nhiều bước cần transaction riêng, không ghép các method DAO này rồi kỳ vọng atomicity.

Chuẩn bị database/schema và PGJDBC_JAR/JDBC_URL/JDBC_USER/JDBC_PASSWORD theo README workspace. Chạy từ `E:\JAVA_FULL\jdbc-practice`:

```powershell
$build = Join-Path $env:TEMP 'jdbc-product-cli-classes'
New-Item -ItemType Directory -Force -Path $build | Out-Null
javac --release 17 -encoding UTF-8 -d $build .\mini-project\solution\src\*.java
java -cp "$build;$env:PGJDBC_JAR" ProductCli
```

Ví dụ phiên nhập: `add` → tên `Notebook` → giá `120.50` → stock `3`; sau đó `list`, `find` theo id được in, `update` id đó rồi `delete`. Dữ liệu được lưu thật vào database học mới; demo không tự xóa toàn bộ bảng.

Đối chiếu: Optional.empty tương ứng không tìm thấy; SQLException tương ứng thao tác thất bại, không trả danh sách rỗng thay lỗi. UPDATE/DELETE nhận count 0 khi id không tồn tại. PreparedStatement giữ tên có dấu nháy như dữ liệu. FK từ stock_movements có thể từ chối xóa product đã có movement; CLI báo lỗi thay vì tự xóa lịch sử.

Giới hạn học tập: chưa phân trang, chưa pool, chưa xử lý cập nhật đồng thời hoặc transaction nhiều DAO. Không thêm Spring/JPA. Để tự nâng cấp, giải thích và xây nghiệp vụ chuyển stock ở exercise riêng.
