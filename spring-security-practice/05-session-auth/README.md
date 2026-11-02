# Session authentication trước JWT

## 1. Problem — khái niệm này giải quyết việc gì?

Sau login, không cần gửi username/password cho mọi thao tác. Server có thể giữ trạng thái đã đăng nhập và cấp một id ngẫu nhiên cho client.

## 2. Mental model

Session ở server gắn id với security context; cookie thường mang JSESSIONID. Cookie là cách truyền id, không phải toàn bộ session. Browser tự gửi cookie phù hợp nên unsafe request cần CSRF protection. Login thành công thay session id để giảm session fixation; logout hủy trạng thái phiên. Demo dùng mặc định session IF_REQUIRED, không ép stateless.

## 3. Ví dụ nhỏ

```text
POST /login + username/password + CSRF
→ xác thực → session server → Set-Cookie
GET /me + Cookie → tìm session → principal → authorization
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: Map-like session state ở server. HTTP: Set-Cookie/Cookie, redirect login, CSRF. SQL: tài khoản có thể lấy từ users sau này; session trong reference không phải row users.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Lưu password trong cookie; nghĩ REST bắt buộc JWT; GET logout làm thay đổi trạng thái; tắt CSRF do API dùng JSON; nghĩ SameSite thay thế mọi CSRF protection.

## 6. Câu hỏi tự kiểm tra

Server giữ gì, browser giữ gì? Vì sao cần fetch CSRF mới sau login? Logout thay đổi request tiếp theo thế nào?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
