# Authentication: bạn là ai?

## 1. Problem — khái niệm này giải quyết việc gì?

Server không thể tin username client tự khai. Cần kiểm tra credential để thiết lập danh tính được tin cậy trước khi dùng nó trong request.

## 2. Mental model

Authentication != Authorization. Authentication chứng minh danh tính; authorization xét danh tính đó được làm gì. Login nhận username/password, kiểm tra với dữ liệu server rồi tạo session hoặc cơ chế token. Client gửi session id/token ở lần sau; server vẫn phải kiểm chứng, không tin object user trong body.

## 3. Ví dụ nhỏ

```text
Login → username/password → authenticate
→ session id hoặc JWT → client gửi token
→ backend xác minh → authorization
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: kết quả xác thực là object Authentication trong security context. HTTP: cookie/header mang bằng chứng, không phải quyền tự khai. SQL: users lưu hash và trạng thái, không lưu plaintext password.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Tin userId từ request; xem đăng nhập xong là toàn quyền; gửi mật khẩu qua query URL; nhầm Base64 với bảo mật.

## 6. Câu hỏi tự kiểm tra

Biết username có đủ xác thực không? Tại sao backend phải xác minh mỗi request sau login? Authentication thất bại khác thiếu quyền thế nào?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
