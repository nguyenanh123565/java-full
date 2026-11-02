# 08 — API: giao kèo giữa các chương trình

## 1. Khái niệm giải quyết vấn đề gì?

API cho phép một chương trình yêu cầu khả năng hoặc dữ liệu của chương trình khác qua một giao kèo rõ ràng. Client cần biết cách gọi và cách đọc kết quả; không cần biết backend dùng Java, lưu bằng PostgreSQL hay giữ trong bộ nhớ.

Một API có thể là hàm Java, thư viện hoặc giao tiếp mạng. Trong workspace này, ta học HTTP API. HTTP API không tự động trở thành REST API.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

API là giao kèo nhìn thấy ở ranh giới request/response. Backend quyết định xử lý nghiệp vụ và có thể dùng database. Với `GET /health`, backend có thể trả lời mà không đọc database; database không phải bước bắt buộc của mỗi request.

## 3. Kiến thức bắt buộc

- Endpoint được phân biệt bằng method cùng đường dẫn; `GET /widgets` và `POST /widgets` có mục đích khác nhau.
- Giao kèo gồm input, kiểu dữ liệu, validation, output, status, lỗi và quyền truy cập.
- JSON là một định dạng trao đổi thường dùng; API cũng có thể trả ảnh, văn bản hoặc định dạng khác.
- Phân biệt lỗi mạng không nhận được response với response báo lỗi từ server.
- Không để client phụ thuộc tên cột database hoặc cấu trúc class nội bộ.
- API ổn định cần quy định rõ trường bắt buộc, trường có thể vắng mặt và ý nghĩa `null`.

## 4. Ví dụ request/response

Ví dụ thiết kế độc lập với lab; lab không có endpoint widgets. Đây là minh họa HTTP/1.1, client/server tự đặt các trường framing còn lại.

```http
GET /widgets/7 HTTP/1.1
Host: api.example.test
Accept: application/json

HTTP/1.1 200 OK
Content-Type: application/json

{"id":7,"name":"Controller","stock":12}
```

Client biết `stock` là số nguyên không âm theo giao kèo, không suy luận quy tắc từ một response duy nhất. Nếu widget không tồn tại, giao kèo cần mô tả một response khác.

Chạy `demo.http` sau khi khởi động lab: quan sát health và products; viết dự đoán trước khi gửi.

## 5. Lỗi thường gặp

- Chỉ liệt kê URL mà không mô tả method, dữ liệu và lỗi.
- Cho rằng gửi request thành công nghĩa là nghiệp vụ thành công.
- Dùng response `200` cho mọi lỗi rồi bắt client đoán từ chuỗi thông báo.
- Trả thông tin riêng như password hash hoặc stack trace.
- Đổi tên trường response tùy hứng làm client hỏng.

## 6. Tự kiểm tra

1. Một API và một bảng database có phải cùng một thứ không? Vì sao?
2. Vì sao endpoint cần được hiểu cùng method?
3. Một HTTP API trả CSV có còn là API không?
4. Client nên làm gì khi không nhận được response sau thao tác tạo dữ liệu?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Viết giao kèo lấy product theo id: input, output thành công, ít nhất hai tình huống lỗi. Giải thích đâu là điều client được bảo đảm.
2. **Vừa:** Với API tạo user, xác định trường client được gửi, trường backend sinh, validation và dữ liệu tuyệt đối không trả lại. Giải thích từng quyết định.
3. **Khó:** Thiết kế cách mở rộng response danh sách orders khi thêm pagination mà vẫn hỗ trợ client cũ; nêu ít nhất hai cách và trade-off.

Làm trong [exercises.md](exercises.md); ghi câu trả lời trước khi mở [solution riêng](../solutions/08-api-basics.md).

Nguồn: [RFC 9110 — HTTP Semantics](https://www.rfc-editor.org/rfc/rfc9110.txt).
