# Solution tham khảo — 14 CORS / HTTPS

## 1. Origin

So với http://localhost:3000: port 8080 khác; scheme https khác; host 127.0.0.1 khác. Chỉ /help giữ cùng scheme/host/port, nên same-origin. Origin không chứa path. Site dùng quy tắc khác; khác port có thể cross-origin mà vẫn same-site.

## 2. Preflight

OPTIONS /cors mang Origin localhost:3000, Access-Control-Request-Method POST, Access-Control-Request-Headers content-type,x-lab-header. Server allowlist phản hồi allow-origin chính xác và danh sách method/header phù hợp, status 204. Sau đó browser có thể gửi POST thật; response thật vẫn cần CORS phù hợp.

Với origin 3001, lab không thêm CORS allow headers. Client .http/Postman vẫn có thể nhìn body; browser script sẽ không được đọc theo policy. Không cần preflight cho mọi GET/simple request nên server có thể đã xử lý request trước khi browser chặn đọc. Lab không kiểm tra authentication hoặc CSRF.

## 3. Credentialed request

Theo giao kèo mẫu, client browser dùng credentials phù hợp; server trả explicit allow-origin, Access-Control-Allow-Credentials true và các method/header cần thiết. Không dùng wildcard allow-origin cho credentialed request. Cookie chỉ đi nếu scope, SameSite/Secure và chính sách browser cho phép; CORS thành công không vượt qua policy cookie.

Backend còn cần chống CSRF cho credentials tự gửi, xác thực session/token, kiểm tra ownership, validation và nghiệp vụ. HTTPS bảo vệ đường truyền và server identity; không xác nhận người gửi có quyền sửa user đó. SameSite khác origin nên phải phân tích riêng. Nếu frontend không phải browser, lớp CORS không thay các kiểm tra backend.
