# 07 — Status codes: client cần hành động gì tiếp theo?

## 1. Vấn đề cần giải quyết

Client không nên đoán thành công hay thất bại bằng một chuỗi message tùy ý. Status diễn đạt loại kết quả để client quyết định hiển thị dữ liệu, sửa input, đăng nhập, chờ hay báo lỗi.

## 2. Vị trí trong luồng

```text
Client → HTTP Request → Backend [quyết định kết quả] → Database → HTTP Response [status] → Client [xử lý]
```

Backend có thể trả 4xx trước khi chạm database, hoặc trả 2xx/5xx sau khi xử lý. Lỗi mạng không có response không phải “HTTP 500”.

## 3. Kiến thức bắt buộc

1xx là thông tin; 2xx thành công; 3xx chuyển hướng/điều kiện cache; 4xx request không thể được đáp ứng theo điều kiện hiện tại; 5xx lỗi phía server. Không phải mọi 4xx đều do lập trình viên client gõ sai.

| Status | Cách hiểu trong bài học |
| --- | --- |
| 200 OK | Xử lý thành công, có thể trả representation |
| 201 Created | Đã tạo resource; contract thường dùng Location để chỉ URI mới |
| 202 Accepted | Đã nhận xử lý nhưng chưa hoàn tất; cần quy tắc theo dõi kết quả |
| 204 No Content | Thành công và **không có response body** |
| 400 Bad Request | Ví dụ request không hợp lệ về cú pháp hoặc input theo contract |
| 401 Unauthorized | Thiếu/không có credentials hợp lệ; response phải có WWW-Authenticate |
| 403 Forbidden | Server hiểu request nhưng từ chối; thường gặp khi không đủ quyền |
| 404 Not Found | Không tìm thấy resource hoặc server không muốn công khai sự tồn tại |
| 405 Method Not Allowed | Method được hiểu nhưng không được cho resource; phải có Allow |
| 409 Conflict | Request xung đột với trạng thái hiện tại, cần xử lý xung đột |
| 415 Unsupported Media Type | Kiểu nội dung hoặc encoding không được chấp nhận |
| 422 Unprocessable Content | Kiểu nội dung hiểu được, cú pháp đúng, nhưng chỉ dẫn không xử lý được |
| 429 Too Many Requests | Bị giới hạn tần suất; chính sách có thể kèm Retry-After |
| 500 Internal Server Error | Điều kiện bất ngờ ngăn server xử lý request |
| 503 Service Unavailable | Server tạm không phục vụ được; có thể kèm Retry-After |

Một API có thể dùng 400 cho validation, API khác chọn 422 khi JSON đúng cú pháp nhưng dữ liệu không được chấp nhận. Công bố contract rõ, áp dụng nhất quán. Duplicate email có thể là 409 theo quy tắc xung đột đã chọn. Không máy móc chuyển mọi lỗi database thành 500.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1 từ endpoint giả lập status, **không phải xác thực thật**:

```http
GET /status/401 HTTP/1.1
Host: localhost:8080

```

```http
HTTP/1.1 401 Unauthorized
Content-Type: application/json
WWW-Authenticate: Bearer realm="http-lab"

{"error":{"code":"DEMO_401","message":"Sample status 401"}}
```

Trong [demo.http](demo.http), hãy đọc cả status, headers và body. `/status/405` chỉ minh họa cấu trúc response 405 với Allow; việc bạn chủ động yêu cầu status không phải lỗi thật của nghiệp vụ. `/status/201` minh họa 201/Location và không tạo sản phẩm mới.

## 5. Lỗi thường gặp

- Trả 200 cho mọi lỗi rồi buộc client dò chuỗi trong message.
- Nhầm 401 với 403 hoặc bỏ WWW-Authenticate khi trả 401.
- Gửi `{ "message": "deleted" }` trong response 204.
- Trả 405 nhưng không gửi danh sách methods được cho phép trong Allow.
- Cho rằng mọi 5xx đều nên retry ngay; retry có thể nhân đôi tác dụng của POST.

## 6. Tự kiểm tra

1. Vì sao 204 không đi kèm JSON body?
2. 401 và 403 giúp client quyết định khác nhau thế nào?
3. Khi nào chọn 400, 409 hoặc 422 cho một input không chấp nhận được?
4. Lỗi timeout chưa có response khác 500 như thế nào?
5. Vì sao status đúng vẫn cần một cấu trúc error body ổn định?

## 7. Ba bài tập

1. **Dễ:** Chọn status cho đọc, tạo, xóa và không tìm thấy resource.
2. **Vừa:** Phân loại lỗi cú pháp, xác thực, quyền, kiểu dữ liệu và xung đột.
3. **Khó:** Sửa response thiếu header hoặc chứa body không phù hợp; thiết kế error contract.

Làm [exercises.md](exercises.md). [Solution riêng](../solutions/07-status-codes.md).

Tham khảo: [RFC 9110 — status codes](https://www.rfc-editor.org/rfc/rfc9110.html#section-15); [RFC 6585 — 429](https://www.rfc-editor.org/rfc/rfc6585.html#section-4).
