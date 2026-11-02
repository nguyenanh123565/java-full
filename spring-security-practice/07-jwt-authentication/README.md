# Xác minh JWT bằng Resource Server

## 1. Problem — khái niệm này giải quyết việc gì?

Copy một custom filter dài che khuất các bước kiểm tra quan trọng. Spring Security đã có bộ xử lý Bearer JWT để ứng dụng tập trung vào quy tắc tin cậy.

## 2. Mental model

Resource Server nhận token từ issuer đã tin, xác minh chữ ký/claims rồi tạo Authentication. Nó không tự là endpoint login hay nơi phát token. Sau session, bài này mới xem cấu hình JWT độc lập. Chỉ API nhận Bearer header từ client và không dùng cookie/Basic/session mới có thể cân nhắc tắt CSRF theo mô hình đó; không sao chép thay đổi sang app session.

## 3. Ví dụ nhỏ

```text
Bearer header → decoder/verifier → issuer/expiry/audience checks
→ principal + authorities → route authorization
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: thư viện kiểm tra token, không tự Base64 parse rồi cấp quyền. HTTP: invalid Bearer token thường 401; đủ xác thực thiếu scope 403. SQL: principal có thể dùng để đọc dữ liệu người dùng, không cần token chứa toàn bộ row.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Chỉ khai báo issuer mà quên audience yêu cầu của API; dùng khóa nhận từ request; cho rằng Resource Server phát token; map scope thành role vô điều kiện.

## 6. Câu hỏi tự kiểm tra

Resource Server khác Authorization Server ở đâu? Khi nào aud cần kiểm tra? Cấu hình STATELESS có tự vô hiệu mọi rủi ro CSRF không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
