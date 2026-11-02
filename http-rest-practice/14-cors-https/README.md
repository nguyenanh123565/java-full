# 14 — CORS và HTTPS

## 1. Khái niệm giải quyết vấn đề gì?

CORS cho phép server khai báo khi JavaScript trên một origin khác được đọc response qua browser. HTTPS bảo vệ dữ liệu khi truyền và giúp client xác thực server qua TLS. Hai cơ chế này giải quyết hai vấn đề khác nhau.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

TLS nằm dưới HTTP trong kết nối HTTPS. Browser kiểm tra CORS quanh request/response; một số request cần preflight OPTIONS trước request thật. Backend vẫn phải xác thực, kiểm tra quyền và bảo vệ nghiệp vụ/database.

## 3. Kiến thức bắt buộc

- Origin gồm scheme + host + port. `http://localhost:3000` khác `http://localhost:8080`, dù có thể cùng site trong nghĩa cookie.
- Same-origin policy và CORS được browser áp dụng; Postman/curl/.http client thường không tự chặn response theo CORS.
- Preflight hỏi server bằng OPTIONS, Origin, Access-Control-Request-Method và có thể Access-Control-Request-Headers.
- Access-Control-Allow-Origin/Methods/Headers là phản hồi policy của server. Khi policy thay đổi theo Origin, dùng Vary: Origin để cache phân biệt.
- Preflight không cần cho mọi request cross-origin. Một số request vẫn gửi trước khi browser chặn việc script đọc response; không dùng CORS thay authorization hoặc CSRF.
- Với credentialed requests, wildcard origin không thay explicit origin; cần cấu hình credentials phù hợp cả client và server. Lab không bật credentialed CORS.
- HTTPS dùng TLS để bảo vệ tính bí mật/toàn vẹn trên đường truyền và xác thực server; không cấp quyền đọc orders cho user.
- Kiểm tra certificate/hostname là phần xác thực server. Không tắt verification để làm bài.
- HTTP/2 và HTTP/3 có framing khác HTTP/1.1; ví dụ text bên dưới dùng HTTP/1.1 để học ngữ nghĩa.

## 4. Ví dụ request/response

Ví dụ preflight đến lab cho request POST JSON có header tùy chỉnh. Minh họa HTTP/1.1; framing được lược bớt.

```http
OPTIONS /cors HTTP/1.1
Host: localhost:8080
Origin: http://localhost:3000
Access-Control-Request-Method: POST
Access-Control-Request-Headers: content-type,x-lab-header

HTTP/1.1 204 No Content
Access-Control-Allow-Origin: http://localhost:3000
Access-Control-Allow-Methods: GET, POST, HEAD
Access-Control-Allow-Headers: Content-Type, X-Lab-Header
Vary: Origin
```

Header names và thứ tự có thể khác; xem giá trị theo ngữ nghĩa, không so nguyên chuỗi response. Khi preflight đạt, browser mới gửi request thật phù hợp. `demo.http` gửi thủ công hai bước; đây là quan sát HTTP, chưa tự mô phỏng cơ chế chặn của browser.

Khởi động browser CORS lab theo [hướng dẫn lab-server](../lab-server/README.md#cors-lab). Mở trang ở http://localhost:3000, thử gọi /cors và đối chiếu Network/Console; thử client ở port 3001 để quan sát origin không được phép. Server HTTP local giúp học CORS; không phải ví dụ triển khai HTTPS.

## 5. Lỗi thường gặp

- “Postman gọi được nên CORS đã đúng cho browser.”
- Dùng Access-Control-Allow-Origin làm kiểm tra quyền.
- Nhầm preflight là thao tác tạo/sửa dữ liệu.
- Gửi mọi origin vào allowlist không xét giao kèo.
- Dùng wildcard với credentials hoặc cho rằng CORS ngăn mọi request tới server.
- “Có HTTPS thì token/user nào cũng được truy cập.”

## 6. Tự kiểm tra

1. Vì sao thay port có thể làm request trở thành cross-origin?
2. Vì sao Postman đọc được response mà JavaScript browser không đọc được?
3. CORS chặn đọc response có đảm bảo backend chưa xử lý request không?
4. Preflight khác request thật thế nào?
5. HTTPS giúp gì và có thay authorization không?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Phân loại cùng/khác origin cho các URL đổi scheme, host, port; giải thích origin và site không hoàn toàn giống nhau.
2. **Vừa:** Tự viết preflight và request thật cho POST JSON có header X-Lab-Header; quan sát /cors với origin được phép và origin khác bằng .http/Postman rồi browser.
3. **Khó:** Phân tích website khác origin dùng cookie gọi API đổi dữ liệu qua HTTPS; tách các điều kiện CORS, cookie, CSRF, xác thực và quyền. Không chỉ sửa một header rồi kết luận an toàn.

Làm trong [exercises.md](exercises.md); đối chiếu [solution](../solutions/14-cors-https.md).

Nguồn: [WHATWG Fetch — CORS protocol](https://fetch.spec.whatwg.org/#http-cors-protocol), [RFC 8446 — TLS 1.3](https://www.rfc-editor.org/rfc/rfc8446.txt).
