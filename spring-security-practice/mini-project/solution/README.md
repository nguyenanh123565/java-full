# Session security reference — app nhỏ hoàn chỉnh

Đây là đáp án riêng cho bài session, chỉ web+security, Java 17 và Boot 3.5.16. List chỉ lưu tên product để tập trung vào filter/session/role; không thay CRUD Product API ở Spring workspace. POST thành công trả 200 với tên đã thêm, không có resource id để khai báo Location.

## Chạy chủ động khi đã có Maven

Maven 3.6.3+, JDK 17–25. Trong terminal PowerShell tại thư mục solution, đặt password **chỉ dùng học** và chạy:

```powershell
$env:LEARNER_PASSWORD = Read-Host 'Mat khau demo cho learner'
$env:ADMIN_PASSWORD = Read-Host 'Mat khau demo cho admin'
mvn spring-boot:run
```

Read-Host tránh ghi literal password vào command history nhưng input ở đây không bị mask; chỉ dùng chuỗi học không tái sử dụng. App thiếu biến sẽ fail startup có tên biến cần đặt, không in giá trị. Khi dừng app, xóa biến trong chính terminal đó bằng `Remove-Item Env:LEARNER_PASSWORD, Env:ADMIN_PASSWORD`. Workspace chưa chạy Maven hay tải dependency.

Browser: mở `http://localhost:8080/products` không cần login; mở `/me` sẽ chuyển form `/login`; dùng learner hoặc admin với password vừa đặt. Đăng nhập chỉ chứng minh danh tính; role quyết định POST. Có thể mở `/logout` để xem trang xác nhận; hành động logout thật là POST có CSRF.

## Gửi request có cookie và CSRF bằng PowerShell

Trong terminal thứ hai, gọi lần lượt; password được nhập phải trùng terminal chạy app. Không chạy đồng thời với app khác cùng port.

```powershell
$base = 'http://localhost:8080'
$cookieSession = New-Object Microsoft.PowerShell.Commands.WebRequestSession
$csrf = Invoke-RestMethod "$base/csrf" -WebSession $cookieSession
$loginBody = @{ username = 'learner'; password = (Read-Host 'Mat khau learner') }
$loginBody[$csrf.parameterName] = $csrf.token
Invoke-WebRequest "$base/login" -Method Post -WebSession $cookieSession -Body $loginBody -UseBasicParsing
Invoke-RestMethod "$base/me" -WebSession $cookieSession
# Login đổi/clear CSRF token; lấy lại sau xác thực.
$csrf = Invoke-RestMethod "$base/csrf" -WebSession $cookieSession
$csrfHeaders = @{}
$csrfHeaders[$csrf.headerName] = $csrf.token
$newProduct = @{ name = 'Book' } | ConvertTo-Json
Invoke-WebRequest "$base/products" -Method Post -ContentType 'application/json' -Body $newProduct -Headers $csrfHeaders -WebSession $cookieSession -UseBasicParsing
```

Dòng POST với learner dự kiến 403 vì thiếu ADMIN nếu CSRF hợp lệ; PowerShell có thể ném exception để báo HTTP error. Tạo WebRequestSession mới và lặp login với username admin để kiểm tra success 200. Đừng chỉ đổi username trong body POST products: danh tính nằm ở session server. Với admin, bỏ `-Headers $csrfHeaders` để thấy CSRF từ chối 403 trước controller.

Logout bằng POST với token hiện tại:

```powershell
$csrf = Invoke-RestMethod "$base/csrf" -WebSession $cookieSession
$logoutBody = @{}
$logoutBody[$csrf.parameterName] = $csrf.token
Invoke-WebRequest "$base/logout" -Method Post -Body $logoutBody -WebSession $cookieSession -UseBasicParsing
```

Sau đó /me lại chuyển tới login. Invoke-WebRequest có thể tự theo redirect và chỉ hiện 200 trang login; xem browser Network hoặc dùng `curl.exe -i` với cookie jar khi cần thấy redirect gốc. Không kết luận “đã đăng nhập” chỉ từ 200 của trang login.

## Lý do cấu hình

PasswordEncoder bean BCrypt hash input environment khi startup; reference không ghi password/database. UserDetailsService giữ hai user trong memory; roles USER và ADMIN được khai rõ, không dựa vào kế thừa ngầm. SecurityFilterChain kiểm GET public, POST ADMIN và phần còn lại authenticated trước MVC. CSRF giữ mặc định vì browser tự gửi cookie; session mặc định IF_REQUIRED phù hợp form login. HttpOnly/SameSite hỗ trợ cookie, không thay CSRF. HTTPS/Secure cookie là việc cần cấu hình khi có môi trường HTTPS thực, localhost chỉ demo.

`@Configuration`/`@Bean` giải quyết việc đăng ký object cấu hình (thủ công tạo/đăng ký filter), không tạo URL. `@SpringBootApplication` khởi động server/container; `@RestController` và mapping thực hiện dispatch/JSON thủ công; `@RequestBody` đọc JSON vào record. `Principal` và `CsrfToken` là tham số MVC được framework cung cấp, không phải dữ liệu role do client tự khai. POST validate tên bằng if Java để không thêm validation dependency chỉ cho bài bảo mật. Tham khảo [annotation map](../../../spring-boot-practice/annotation-map.md).

Giới hạn: memory mất khi restart, không đăng ký/đổi mật khẩu, không tài khoản database, không JWT. Chưa chạy build/runtime do máy chưa có Maven; đã kiểm tra cấu trúc POM/source và liên kết tài liệu, không tuyên bố test đã pass. Dùng [guided JWT](../../guided-jwt.md) sau khi giải thích được demo session này.
