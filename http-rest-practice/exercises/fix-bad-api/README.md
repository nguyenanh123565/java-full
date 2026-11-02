# Sửa API thiết kế sai

## 1. Vấn đề cần giải quyết

Một API có thể chạy và trả JSON nhưng vẫn gây hiểu nhầm, làm client retry sai hoặc lộ dữ liệu. Bài này luyện nhận xét thiết kế bằng tác động cụ thể lên người dùng và backend.

## 2. Vị trí trong luồng

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Lỗi có thể nằm ở hợp đồng request, kiểm tra quyền trước khi query, cách cập nhật database hoặc thông tin response. Hãy xác định vị trí gây lỗi trước khi sửa URL.

## 3. Kiến thức bắt buộc

- Safe method phục vụ thao tác đọc theo semantics; không dùng GET để yêu cầu ghi dữ liệu.
- HTTP status phải diễn đạt kết quả để client xử lý; JSON lỗi cần nhất quán và không lộ chi tiết bí mật.
- Resource identity, representation và database schema là ba khái niệm khác nhau.
- Authentication không thay thế authorization trên resource cụ thể.
- Collection cần giới hạn; idempotency phải được phân tích theo trạng thái cuối, không chỉ response.
- Không coi một quy ước URL là toàn bộ định nghĩa REST; giải thích vì sao quy ước giúp hợp đồng rõ hơn.

## 4. Ví dụ ngoài bài tập

API giả định sửa thư mục tài liệu bằng GET khiến đọc liên kết cũng đổi dữ liệu. Một thiết kế cho phép thay đổi có chủ ý:

```http
PATCH /folders/4 HTTP/1.1
Host: api.example.test
Content-Type: application/merge-patch+json

{"name":"Java notes"}
```

```http
HTTP/1.1 204 No Content
```

Đây là minh họa giả định cho JSON Merge Patch; không có endpoint này trong lab. Response 204 không có body.

## 5. Lỗi thường gặp

- Chỉ bỏ động từ trong URL rồi bỏ qua lỗi method, status và quyền.
- Áp đặt một đáp án cho mọi nghiệp vụ hủy, hoàn tiền hoặc khóa tài khoản.
- Dùng path user id như bằng chứng đã xác thực.
- Cho rằng 404 là bắt buộc khi collection lọc không có kết quả.

## 6. Tự kiểm tra

1. Tại sao một link GET xóa dữ liệu có thể gây xóa ngoài ý muốn?
2. 400, 401, 403, 404, 409 giải quyết các tình huống khác nhau nào?
3. Những phần nào của lỗi cần cho client, phần nào chỉ nên vào log backend?
4. Vì sao sửa URL không đủ để bảo vệ order của người khác?
5. Khi PATCH gửi lặp, bạn cần biết semantics của body nào?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Sửa method và URL ở cases 1–3, giải thích hậu quả của thiết kế cũ.
2. **Vừa:** Sửa status, parameter và JSON ở cases 4–6; viết request/response mới.
3. **Khó:** Sửa quyền, retry, phân trang và hủy order ở cases 7–10; nêu ràng buộc nghiệp vụ.

Không gửi các request nguy hiểm vào hệ thống thật. Đây là hợp đồng giả định để phân tích, lab không triển khai các thao tác này. [Solutions](../../solutions/exercises/fix-bad-api.md) chỉ sửa một case và đưa câu hỏi gợi mở cho phần còn lại.

Tham khảo: [HTTP Semantics — RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html), [JSON Merge Patch — RFC 7396](https://www.rfc-editor.org/rfc/rfc7396.html), [Problem Details — RFC 9457](https://www.rfc-editor.org/rfc/rfc9457.html).
