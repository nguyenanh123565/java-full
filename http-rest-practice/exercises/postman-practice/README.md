# Thực hành HTTP bằng Postman

## 1. Vấn đề cần giải quyết

Quan sát request thật, headers, body và response; lưu các case để ôn lại thay vì chỉ đọc ví dụ. Postman là client gửi HTTP, không tự tạo backend cho những URL bạn nhập.

## 2. Vị trí trong luồng

`Client (Postman) → HTTP Request → Backend → Database → HTTP Response → Client`

Trong lab, backend Java thuần dùng bộ nhớ, không đọc PostgreSQL. Request mini API do bạn thiết kế chưa có backend thực thi.

## 3. Kiến thức bắt buộc

- Tạo collection `HTTP REST Practice` và environment local với biến `baseUrl = http://localhost:8080`.
- Chạy lab theo README gốc trước; dùng Postman desktop hoặc web với Desktop Agent để truy cập localhost.
- Chọn method, URL, tab Params, Headers và Body có chủ ý; không nhập headers response vào request.
- Chọn Body → raw → JSON cho request JSON; kiểm tra `Content-Type` thực tế client gửi.
- Đọc status, response headers và raw body; Pretty chỉ là cách client hiển thị.
- `/echo` phản chiếu nhóm headers được lab công bố và body string trong `receivedBody`; không parse JSON, không lưu data, không xác thực token.
- Postman gửi được request không chứng minh browser vượt CORS; CORS là kiểm soát của browser.
- Không lưu token thật trong collection học hoặc commit bí mật vào Git.

## 4. Ví dụ ngoài bài tập

Ví dụ thiết kế giả định, chưa được lab hỗ trợ:

```http
GET /version HTTP/1.1
Host: api.example.test
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"version":"1.0"}
```

Trong Postman, method là GET, URL gồm scheme/host/path; response JSON hiển thị riêng khỏi status.

## 5. Lỗi thường gặp

- Gửi localhost trong web mà không có agent phù hợp; quên khởi động server hoặc dùng sai port.
- Chọn form-data trong khi muốn raw JSON; nhầm `Accept` với `Content-Type`.
- Tự nhập `Content-Length` sai; hãy để client tính.
- Thấy `/status/201` rồi tưởng một product đã được tạo; đây chỉ là route mô phỏng status.
- Tưởng Postman thành công đồng nghĩa CORS browser đã đúng.

## 6. Tự kiểm tra

1. Collection khác environment thế nào? Vì sao dùng biến baseUrl?
2. JSON nằm trong raw body và trong query khác nhau ra sao?
3. Vì sao header có thể được Postman tự thêm dù bạn không gõ?
4. Tại sao `/echo` nhận JSON hỏng vẫn chưa chứng minh API nghiệp vụ chấp nhận JSON hỏng?
5. Khi Postman không nhận response, bạn phân biệt lỗi kết nối với HTTP 500 thế nào?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Cases 1–2: tạo collection/environment, gửi health và product rồi ghi kết quả.
2. **Vừa:** Cases 3–5: gửi query/headers/body, thử status và method; luôn dự đoán trước.
3. **Khó:** Cases 6–8: tự lập bảng kiểm tra, so sánh browser CORS, lưu request của API tự thiết kế và chỉ rõ route chưa chạy.

`demo.http` là lựa chọn gửi từ IDE nếu hỗ trợ REST Client; bạn cũng có thể nhập tay vào Postman. Không cần import collection hay thêm thư viện. Hướng dẫn thao tác ở [solutions](../../solutions/exercises/postman-practice.md) không cung cấp toàn bộ expected outputs của bài tập.

Tham khảo: [Sending requests — tài liệu Postman](https://learning.postman.com/docs/use/send-requests/requests/), [Variables — tài liệu Postman](https://learning.postman.com/docs/use/send-requests/variables/variables/).
