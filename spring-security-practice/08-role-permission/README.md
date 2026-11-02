# Role và permission có chủ đích

## 1. Problem — khái niệm này giải quyết việc gì?

Tên role tiện khi ít nhóm người dùng, nhưng quyền cụ thể giúp mô tả một hành động. Nhầm prefix hoặc tin role từ body có thể mở nhầm route.

## 2. Mental model

Authority là chuỗi quyền; role thường là authority có prefix ROLE_. `hasRole("ADMIN")` kiểm ROLE_ADMIN; `hasAuthority("product:write")` kiểm đúng chuỗi đó. Role không tự bao gồm role khác nếu chưa cấu hình. Ownership là quy tắc thêm theo tài nguyên.

## 3. Ví dụ nhỏ

```java
User.withUsername("admin").password(hash).roles("ADMIN").build();
// roles("ADMIN") tạo ROLE_ADMIN; không truyền ROLE_ADMIN vào roles().
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: Set<String>/membership. HTTP: route write yêu cầu quyền ở server. SQL: user_roles có thể biểu diễn quan hệ nhiều-nhiều; row chủ sở hữu vẫn cần kiểm tra.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

hasRole("ROLE_ADMIN") sai prefix; ADMIN tự có USER dù không khai báo; check role ở UI; thêm quyền nhờ JSON client.

## 6. Câu hỏi tự kiểm tra

Role và authority khác nhau ở cách biểu diễn nào? Vì sao ADMIN trong reference được khai cả USER lẫn ADMIN? USER có được xem mọi user order không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
