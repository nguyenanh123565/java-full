# JWT: cấu trúc đọc được chưa phải đáng tin

## 1. Problem — khái niệm này giải quyết việc gì?

Một token có thể mang claims để server kiểm tra mà không tra session riêng cho mỗi request. Nhưng chữ ký và chính sách claims mới tạo niềm tin, không phải việc đọc được JSON.

## 2. Mental model

JWT có header.payload.signature với Base64URL cho header/payload. JWT thường được ký, không tự mã hóa nội dung. Decode chỉ đọc dữ liệu; validation kiểm chữ ký bằng khóa tin cậy, thuật toán cho phép và claims exp/nbf/iss/aud theo hợp đồng. Không tin role/sub trước validation.

## 3. Ví dụ nhỏ

```text
header: thuật toán, loại token
payload: sub, iss, aud, exp...
signature: bằng chứng tính toàn vẹn/nguồn phát hành
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: parse dữ liệu khác xác thực dữ liệu. HTTP: Authorization: Bearer token, HTTPS cần thiết. SQL: sub liên kết danh tính; không nhét password hoặc toàn bộ user row vào payload.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Decode rồi coi là verified; để client sửa role; đặt bí mật trong payload; chấp nhận thuật toán do token tự chọn; nghĩ logout session thu hồi mọi JWT.

## 6. Câu hỏi tự kiểm tra

Payload đọc được có đồng nghĩa token hợp lệ không? exp, iss, aud trả lời những câu hỏi gì? Token hết hạn xử lý ở client hay server?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
