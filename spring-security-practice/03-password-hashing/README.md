# BCrypt và kiểm tra mật khẩu

## 1. Problem — khái niệm này giải quyết việc gì?

Database có thể bị lộ. Lưu plaintext hoặc mã hóa đảo ngược bằng một khóa duy nhất làm mọi mật khẩu dễ bị thu hồi; hash nhanh cũng cho phép thử đoán rất nhiều lần.

## 2. Mental model

Password hashing một chiều dùng salt ngẫu nhiên và chi phí tính toán. BCrypt là adaptive hash: work factor tăng chi phí, salt đi cùng chuỗi hash. `encode(raw)` tạo hash; `matches(raw, storedHash)` kiểm tra. Không giải mã hash và không so hai lần encode bằng equals. Cần HTTPS khi truyền password; hash không bảo vệ đường truyền.

## 3. Ví dụ nhỏ

```java
PasswordEncoder encoder = new BCryptPasswordEncoder();
String stored = encoder.encode(rawPassword);
boolean accepted = encoder.matches(rawPassword, stored);
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: String/boolean, gọi thư viện thay tự viết crypto. HTTP: login gửi credential qua HTTPS khi triển khai. SQL: cột password_hash lưu chuỗi hash gồm thông tin salt/cost, không lưu raw password.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Dùng SHA-256 trần/MD5; so encode(input).equals(stored); log password; nghĩ salt phải bí mật; chọn cost quá cao mà không đo.

## 6. Câu hỏi tự kiểm tra

Vì sao cùng password tạo hash khác nhau vẫn kiểm tra được? Cost đánh đổi điều gì? Hash có phải encryption không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
