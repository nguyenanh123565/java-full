# 13 — Cookie, session và JWT: ba khái niệm khác nhau

## 1. Khái niệm giải quyết vấn đề gì?

Sau khi đăng nhập, client cần mang bằng chứng hoặc một tham chiếu giúp backend nhận diện những request tiếp theo. Cookie, session và JWT giải quyết các phần khác nhau của bài toán này; không phải ba lựa chọn loại trừ nhau.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Server có thể gửi Set-Cookie trong response; browser quyết định lưu/gửi Cookie theo policy. Backend có thể tra session id trong nơi lưu trạng thái hoặc kiểm tra token rồi kiểm tra quyền. Database/session store là lựa chọn triển khai; không tự xuất hiện vì request có cookie.

## 3. Kiến thức bắt buộc

- **Cookie:** cơ chế lưu và gửi một giá trị với request theo phạm vi/policy browser. Cookie có thể mang session id hoặc token, không nhất thiết dùng cho đăng nhập.
- **Session:** cơ chế ứng dụng giữ trạng thái phiên, thường tra cứu bằng id khó đoán. Xóa cookie ở client không nhất thiết xóa session trên server.
- **JWT:** định dạng token chứa claims; có thể được bảo vệ bằng chữ ký/MAC hoặc mã hóa. JWT ký không mã hóa payload; base64url không giữ bí mật.
- JWT có thể gửi trong Authorization hoặc cookie. Session id cũng có thể mang theo cách khác. Phân biệt cách vận chuyển, định dạng token và cách lưu trạng thái.
- Token hợp lệ về chữ ký chưa đủ: backend cần kiểm tra thuật toán được cho phép, issuer/audience/thời hạn theo giao kèo và quyền truy cập resource.
- JWT không bảo đảm “không cần state”: revocation, refresh token hoặc đổi quyền ngay có thể cần trạng thái backend.
- HttpOnly hạn chế script đọc cookie; Secure giới hạn gửi qua kết nối an toàn; SameSite kiểm soát một số tình huống cross-site. SameSite khác same-origin.
- Cookie tự gửi trong browser cần xem xét CSRF. SameSite là một lớp bảo vệ, không thay thế mọi kiểm tra; CORS không thay thế CSRF hoặc authorization.
- Không đặt password, password hash hoặc dữ liệu bí mật trong JWT payload; không dùng token thật trong bài thực hành.

## 4. Ví dụ request/response

Ví dụ thiết kế session cho web HTTPS, không phải chức năng login của lab. Minh họa HTTP/1.1; framing được lược bớt.

```http
POST /sessions HTTP/1.1
Host: api.example.test
Content-Type: application/json

{"email":"learner@example.test","password":"demo-only"}

HTTP/1.1 201 Created
Set-Cookie: sid=FAKE-SESSION-ID; Path=/; HttpOnly; Secure; SameSite=Lax
Cache-Control: no-store
Content-Type: application/json

{"authenticated":true}
```

Request sau từ browser phù hợp policy có thể mang `Cookie: sid=FAKE-SESSION-ID`. Giá trị giả ở đây không xác thực ai.

`demo.http` gửi cookie/token giả tới echo. Nó chỉ quan sát header do bạn tự gửi, không chứng minh browser áp Secure/HttpOnly/SameSite, server lưu session hay xác minh JWT.

## 5. Lỗi thường gặp

- “Dùng JWT thì không thể dùng cookie.”
- “Decode được JWT nghĩa là đã xác minh chữ ký.”
- Cho rằng payload đã mã hóa vì không đọc trực tiếp chuỗi base64url.
- Logout chỉ xóa dữ liệu client nhưng token/session còn hiệu lực.
- Cho rằng HttpOnly ngăn mọi tác hại của XSS.
- Chọn nơi lưu token mà không phân tích XSS/CSRF và kiến trúc client.

## 6. Tự kiểm tra

1. JWT có thể đặt trong cookie không? Session có bắt buộc dùng cookie không?
2. Decode và verify token khác nhau thế nào?
3. Xóa cookie client có thu hồi session server không?
4. JWT còn hạn có phải luôn giữ nguyên quyền tới khi hết hạn không?
5. Vì sao SameSite và CORS giải quyết những phần khác nhau?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Phân loại cookie/session/JWT/Authorization theo transport, định dạng và nơi lưu state; chỉ ra các cách kết hợp.
2. **Vừa:** Thiết kế chuỗi login, gọi API, logout cho session id trong cookie; giải thích từng thuộc tính cookie và state backend.
3. **Khó:** Phân tích JWT có role/thời hạn nhưng user bị khóa ngay sau khi phát token; đề xuất policy thu hồi/đổi quyền và nêu trade-off state.

Làm trong [exercises.md](exercises.md); đối chiếu [solution](../solutions/13-cookie-session-jwt.md).

Nguồn: [RFC 7519 — JWT](https://www.rfc-editor.org/rfc/rfc7519.txt), [RFC 8725 — JWT best practices](https://www.rfc-editor.org/rfc/rfc8725), [HTTPWG cookie specification (bản dự thảo đang phát triển)](https://httpwg.org/http-extensions/draft-ietf-httpbis-rfc6265bis.html).
