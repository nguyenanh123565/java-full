# Product API tham chiếu — project Maven hoàn chỉnh

Chỉ dùng Spring web và validation, Java 17, Boot 3.5.16. Dữ liệu memory ban đầu rỗng. Source đầy đủ ở src/main/java/learn/products. Đây là reference sau lần tự làm; không cần copy vào starter.

## Chạy khi chủ động thực hành

Yêu cầu JDK 17–25 và Maven 3.6.3+. Mở terminal trong thư mục này rồi `mvn spring-boot:run`. Đợi server báo started; lần đầu Maven có thể tải dependency. Muốn build jar: `mvn package`, sau đó `java -jar target/product-api-solution-1.0.0.jar`. Dừng bằng Ctrl+C. Workspace được tạo mà chưa chạy các lệnh này.

PowerShell ở terminal thứ hai:

```powershell
$base = 'http://localhost:8080'
Invoke-RestMethod "$base/products"
$body = @{ name = 'Notebook'; price = 25.50 } | ConvertTo-Json
$created = Invoke-RestMethod "$base/products" -Method Post -ContentType 'application/json' -Body $body
Invoke-RestMethod "$base/products/$($created.id)"
$changed = @{ name = 'Notebook A5'; price = 30.00 } | ConvertTo-Json
Invoke-RestMethod "$base/products/$($created.id)" -Method Put -ContentType 'application/json' -Body $changed
Invoke-WebRequest "$base/products/$($created.id)" -Method Delete -UseBasicParsing
```

`Invoke-RestMethod` hiển thị body, còn muốn xem status/Location hãy dùng `Invoke-WebRequest -UseBasicParsing` với cùng method/body. Các request lỗi có thể làm PowerShell ném exception; xem status từ response của exception hoặc dùng `curl.exe -i`.

## Kiểm tra có ý nghĩa

Trước mỗi bước ghi dự đoán. GET danh sách đầu tiên → 200 array rỗng; POST hợp lệ → 201 + Location; GET id vừa tạo → 200; PUT → 200 và giá trị mới; DELETE → 204 không body; GET sau xóa → 404. POST name trắng hoặc price âm/null → 400. GET /products/abc → 400. Dừng/chạy lại: list rỗng; đây là memory, không phải PostgreSQL.

## Vì sao code chia như vậy?

Controller chỉ xử lý hợp đồng HTTP. Service giữ use case và mapping DTO; repository quản lý id và Map. `computeIfPresent` tránh chuỗi check rồi put có thể làm sống lại item bị xóa ở giữa. Danh sách sắp theo id để đầu ra dễ đọc; không cam kết snapshot transaction khi có nhiều request đồng thời. BigDecimal cho giá thập phân; request không có id, server quyết định id.

Validation chạy ở biên HTTP; service giả định request từ controller đã hợp lệ. Nếu sau này gọi service từ CLI, cần kiểm tra đầu vào của đường gọi đó. ApiErrors dịch not found và validation; lỗi không lường trước vẫn là 500, không che bằng 200. Chưa có auth hay lưu bền vững; học chúng ở workspace riêng.

Từng annotation được giải thích ở [annotation-map](../../annotation-map.md). Dữ liệu không chứa SQL hoặc credential. Chưa chạy Maven do môi trường chưa có Maven; POM/source chỉ được kiểm tra cấu trúc, không tuyên bố build/runtime đã pass.
