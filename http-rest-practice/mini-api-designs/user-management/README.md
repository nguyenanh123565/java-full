# Mini thiết kế — User Management

## 1. Vấn đề cần giải quyết

Thiết kế API quản lý tài khoản để frontend biết đọc, tạo và cập nhật user; đồng thời bảo vệ dữ liệu cá nhân. Đây là bộ yêu cầu để bạn viết contract, chưa có backend CRUD hay đăng nhập được triển khai.

## 2. Vị trí trong luồng

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Backend xác thực người gọi, kiểm tra quyền trên user được yêu cầu, validation và xử lý uniqueness trước khi ghi database. Response là representation được chọn, không trả nguyên object/bảng chứa mọi field.

## 3. Kiến thức bắt buộc

- Resource identity khác thông tin tài khoản có thể đổi như email.
- Tách public response, request tạo user và dữ liệu nội bộ; không trả password/hash/token bí mật.
- Authentication trả lời ai đang gọi; authorization trả lời người đó được làm gì với user cụ thể.
- Client không tự chọn role admin qua body; quyền do backend kiểm soát.
- Duplicate email, id không tồn tại, input hỏng và thiếu quyền là các trường hợp khác nhau.
- Collection có phân trang; update công bố semantics field thiếu/null và retry.
- Không dùng query/path làm nguồn đáng tin cho user đang đăng nhập.

## 4. Ví dụ ngoài bài tập

API giả định đọc danh sách vai trò, không có route này trong lab:

```http
GET /roles HTTP/1.1
Host: api.example.test
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"items":[{"code":"CUSTOMER","name":"Customer"}]}
```

Đọc danh sách role không có nghĩa client được tự gán role đó cho mình.

## 5. Lỗi thường gặp

- Trả nguyên record user nên lộ password hash.
- Token hợp lệ nhưng bỏ qua quyền xem user khác.
- Cho client gửi `admin=true` hoặc role bất kỳ.
- Không nói email có được chuẩn hóa hay phải duy nhất theo quy tắc nào.

## 6. Tự kiểm tra

1. Ai được đọc một user: khách, chính user đó hay admin?
2. Vì sao phải có whitelist field trong response?
3. Duplicate email khác id không tồn tại thế nào?
4. Khi đổi tên, field email bị bỏ qua sẽ giữ nguyên hay bị xóa?
5. Xóa user có ảnh hưởng lịch sử order không?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Thiết kế đọc user và collection có phân trang; viết hai success responses và các lỗi liên quan.
2. **Vừa:** Thiết kế tạo và cập nhật thông tin user; validation, uniqueness, headers, status và field được phép sửa.
3. **Khó:** Thiết kế quyền theo vai trò/chủ sở hữu, đọc orders của user và ngừng hoạt động tài khoản có order lịch sử.

Làm TODO trong `exercises.md`; viết contract của bạn vào `my-contract.md`, tự điền `requests.http`. Không có endpoint CRUD tương ứng trong lab. [Rubric](../../solutions/mini-api-designs/user-management.md) chỉ giúp tự chấm, không cung cấp ma trận endpoint.

Tham khảo: [HTTP Semantics — RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html).
