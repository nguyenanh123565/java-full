# 12 — Authentication và authorization

## 1. Khái niệm giải quyết vấn đề gì?

Authentication xác định ai đang gọi; authorization quyết định người đó được làm gì với tài nguyên cụ thể. Có thể đăng nhập thành công mà vẫn không được đọc đơn của người khác.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Client gửi thông tin xác thực theo giao kèo. Backend xác thực, kiểm tra quyền và điều kiện nghiệp vụ trước khi đọc/sửa dữ liệu hoặc trả representation. User id ở URL/body không thay thế danh tính đã được xác thực.

## 3. Kiến thức bắt buộc

- Credentials có thể là mật khẩu trong quy trình đăng nhập, session id hoặc access token; phải được xử lý ở backend.
- Header Authorization là một cách mang credentials, không phải bằng chứng tự động rằng request đáng tin.
- `401` báo thiếu hoặc không có credentials hợp lệ cho tài nguyên; response cần challenge `WWW-Authenticate`.
- `403` báo server hiểu nhưng từ chối thực hiện. Trong giao kèo auth thường dùng khi danh tính đã hợp lệ nhưng thiếu quyền; có thể dùng 404 theo chính sách che giấu tồn tại.
- Quyền theo role và quyền theo resource ownership là hai kiểm tra khác nhau. “customer” không được đọc mọi order của mọi customer.
- Frontend ẩn nút chỉ cải thiện UI; backend phải kiểm tra từng request.
- Không nhận role/userId trong body rồi coi đó là quyền đã được cấp.
- Dữ liệu trả về cũng cần giới hạn theo quyền; không trả password/hash, chi tiết nhạy cảm hoặc stack trace.

## 4. Ví dụ request/response

Ví dụ giao kèo API giả định, không phải xác thực của lab. Minh họa HTTP/1.1; framing được lược bớt.

```http
GET /invoices/82 HTTP/1.1
Host: api.example.test
Authorization: Bearer <access-token>

HTTP/1.1 403 Forbidden
Content-Type: application/json

{"error":{"code":"FORBIDDEN","message":"You cannot access this invoice"}}
```

Giả định token hợp lệ nhưng invoice không thuộc user và user không có quyền quản trị. Nếu thiếu credentials, một response có thể là `401` với `WWW-Authenticate: Bearer realm="api"`.

`demo.http` gửi token giả tới echo để quan sát header, và xem status mẫu. Lab không kiểm tra token, role hay ownership; status mẫu không chứng minh một hệ thống auth hoạt động.

## 5. Lỗi thường gặp

- Gộp “đã đăng nhập” và “được phép” thành một kiểm tra.
- Chỉ kiểm tra user có role customer, bỏ qua chủ sở hữu order.
- Tin userId từ request body.
- Kiểm tra quyền chỉ ở frontend.
- Thiếu WWW-Authenticate trong 401 hoặc xem 403 luôn nghĩa là token sai.
- Log toàn bộ token/mật khẩu khi debug.

## 6. Tự kiểm tra

1. Token hợp lệ có đảm bảo user được đọc mọi order không?
2. Vì sao thay userId trên URL cần được backend kiểm tra?
3. 401 thường khác 403 thế nào trong một API có xác thực?
4. Ẩn nút xóa trên frontend có bảo vệ dữ liệu không?
5. CORS có thể thay thế kiểm tra quyền không?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Chọn response cho thiếu token, token không hợp lệ, user hợp lệ nhưng thiếu quyền; giải thích header liên quan.
2. **Vừa:** Thiết kế kiểm tra ownership cho orders của user và order theo id; xác định dữ liệu backend cần so sánh.
3. **Khó:** Thiết kế ma trận quyền customer/admin cho đọc orders, tạo/sửa/xóa products và hủy order; thêm điều kiện trạng thái, lỗi và quy tắc dữ liệu được trả.

Làm trong [exercises.md](exercises.md); đối chiếu [solution](../solutions/12-authentication-authorization.md).

Nguồn: [RFC 9110 — Authentication và 401/403](https://www.rfc-editor.org/rfc/rfc9110.txt).
