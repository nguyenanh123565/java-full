# 11 — Stateless, safe, idempotent và retry

## 1. Khái niệm giải quyết vấn đề gì?

Client có thể timeout, mất response hoặc gửi lại request. Hiểu stateless và idempotent giúp bạn xác định request cần mang gì và retry có gây tác dụng phụ lặp lại không.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Stateless định hướng ngữ cảnh cần có trong mỗi request. Idempotency nói về tác động dự định của request lên trạng thái backend/resource khi nhận nhiều lần cùng yêu cầu. Client có thể không biết backend đã commit database trước khi kết nối bị ngắt.

## 3. Kiến thức bắt buộc

- HTTP không tự giữ ngữ cảnh hội thoại giữa các message; ứng dụng vẫn có thể xây session trên HTTP.
- Stateless trong REST: mỗi request đủ thông tin để hiểu mà không phụ thuộc ngữ cảnh hội thoại được server nhớ từ request trước. Không cấm database hoặc trạng thái nghiệp vụ.
- **Safe:** ý định request chỉ đọc, không yêu cầu đổi trạng thái resource. GET/HEAD là safe; server vẫn có thể ghi log.
- **Idempotent:** lặp cùng request có tác động dự định như thực hiện một lần. Không yêu cầu status/body giống nhau.
- GET/HEAD/PUT/DELETE có ngữ nghĩa idempotent; POST không được bảo đảm mặc định. PUT đặt trạng thái khác “tăng thêm một đơn vị”.
- PATCH có thể idempotent nếu đặt một giá trị, có thể không nếu yêu cầu tăng/append; phụ thuộc định dạng và ngữ nghĩa cụ thể.
- POST có thể hỗ trợ idempotency key khi server công bố giao kèo: phạm vi key, thời hạn, payload trùng/khác và xử lý đồng thời. Chỉ gửi header không tự tạo bảo đảm.
- Idempotent không giải quyết tất cả vấn đề cạnh tranh. Điều kiện phiên bản như ETag/If-Match giúp tránh ghi đè dữ liệu mới.

## 4. Ví dụ request/response

Ví dụ thiết kế độc lập với lab, minh họa HTTP/1.1 và lược framing.

```http
PUT /preferences/9 HTTP/1.1
Host: api.example.test
Content-Type: application/json

{"language":"vi","timezone":"Asia/Ho_Chi_Minh"}

HTTP/1.1 204 No Content
```

Gửi cùng yêu cầu lần hai vẫn yêu cầu đặt cùng cấu hình. Body response hoặc thời gian ghi log có thể khác. Với DELETE, lần một có thể 204 và lần hai 404 theo giao kèo; mục tiêu xóa liên kết vẫn đã đạt.

Trong lab, `demo.http` lặp GET và gửi PUT tới echo. Echo chỉ phản chiếu request, không chứng minh việc lưu resource hoặc bảo đảm retry trong hệ thống thật.

## 5. Lỗi thường gặp

- “Idempotent nghĩa là nhận JSON giống hệt.”
- Retry mọi POST sau timeout mà không biết lần đầu đã thành công hay chưa.
- Gọi request PATCH nào cũng không idempotent.
- Gọi server có database là stateful trong nghĩa REST.
- Nghĩ idempotency key do client gửi đã đủ, dù backend chưa xử lý nó.
- Dùng GET để tăng số lượng hàng trong giỏ.

## 6. Tự kiểm tra

1. Vì sao response DELETE 204 rồi 404 không nhất thiết vi phạm idempotency?
2. Đặt stock thành 5 và cộng stock thêm 5 khác nhau khi retry?
3. Sau timeout tạo order, client có biết chắc order chưa được tạo không?
4. Stateless có cấm lưu đơn hàng trong database không?
5. Server cần làm gì với cùng idempotency key nhưng payload khác?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Phân loại đọc product, thay thế product, xóa product, tăng stock và tạo order theo safe/idempotent; ghi rõ giả định.
2. **Vừa:** Phân tích hai kiểu PATCH: đặt stock và tăng stock. Dự đoán trạng thái sau hai request giống nhau; giải thích vì sao.
3. **Khó:** Thiết kế retry tạo order khi mất response bằng idempotency key; nêu phạm vi key, lưu kết quả, payload khác và xử lý hai request đồng thời.

Làm trong [exercises.md](exercises.md); đối chiếu [solution](../solutions/11-stateless-idempotent.md).

Nguồn: [RFC 9110 §9.2 — Method properties](https://www.rfc-editor.org/rfc/rfc9110.txt), [RFC 5789 — PATCH](https://www.rfc-editor.org/rfc/rfc5789).
