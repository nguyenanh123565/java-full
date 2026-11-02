# Authorization: bạn được làm gì?

## 1. Problem — khái niệm này giải quyết việc gì?

Hai tài khoản hợp lệ có thể có quyền khác nhau. Bảo vệ tài nguyên cần quy tắc trên server, kể cả khi giao diện đã ẩn nút.

## 2. Mental model

Xác thực cung cấp principal và authorities; authorization đối chiếu method/path với quyền. Kiểm tra quyền diễn ra ở server trước hành động. Role là nhóm quyền; ownership là điều kiện theo dữ liệu, không được thay thế bởi việc có role USER.

## 3. Ví dụ nhỏ

```text
GET /products → public
GET /me → đã đăng nhập
POST /products → ADMIN
GET /users/42/orders → cần kiểm tra ownership/ADMIN khi triển khai
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: predicate/if trên principal. HTTP: 403 cho đã đăng nhập nhưng thiếu quyền trong reference. SQL: where user_id = ? có thể hỗ trợ ownership sau khi server xác định user.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Chỉ ẩn nút phía client; nhận role từ JSON; cho USER xem mọi order theo id; nhầm authenticated() với hasRole().

## 6. Câu hỏi tự kiểm tra

Vì sao user hợp lệ vẫn bị từ chối? Route role-check có đủ bảo vệ đơn hàng riêng của từng user không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
