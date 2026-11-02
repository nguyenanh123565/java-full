# Đối chiếu CLI sau khi tự viết

Chạy từ thư mục gốc:

```powershell
java backend-mini-projects/01-java-cli-product-management/solution/ProductCli.java
```

Lệnh phân tách bằng `|`: `add|Book|12.50|3`, `list`, `find|1`,
`update|1|Notebook|15.00|4`, `delete|1`, `quit`. Name không chứa `|` trong bài này.
Giá dùng BigDecimal; Map cấp ID tăng dần; dữ liệu chỉ sống trong process.
Validation nằm trong hàm tạo Product để cả add/update đều tuân thủ.
