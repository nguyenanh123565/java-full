# Dự đoán request và response

## 1. Vấn đề cần giải quyết

Đọc một request và giải thích backend có thể hiểu gì từ nó trước khi nhấn Send. Dự đoán trước giúp phân biệt sai method, sai URL, sai dữ liệu với lỗi nghiệp vụ.

## 2. Vị trí trong luồng

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Bạn phân tích cả hai mũi tên HTTP. Backend có thể từ chối request trước khi truy cập database; một request hợp lệ cũng có thể đọc dữ liệu từ bộ nhớ. Lab Java thuần trong workspace dùng dữ liệu trong bộ nhớ, chưa kết nối PostgreSQL.

## 3. Kiến thức bắt buộc

- Tách method, request target, headers và body; phân biệt headers request với headers response.
- Path chỉ tài nguyên; query thường mô tả bộ lọc. Body là dữ liệu riêng, không tự trở thành query.
- `Content-Type` mô tả body được gửi; `Accept` mô tả kiểu response client muốn nhận.
- Dự đoán dựa trên hợp đồng endpoint: HTTP không tự quyết định cấu trúc JSON của API.
- `HEAD` trả metadata như `GET` nhưng không có response body; `204` cũng không có body.
- Ghi rõ điều chắc chắn theo HTTP và điều chỉ là giả định về nghiệp vụ. `/echo` có trường `receivedBody` kiểu string và chỉ phản chiếu nhóm headers được mô tả trong README lab.

## 4. Ví dụ ngoài bài tập

Ví dụ thiết kế giả định, chưa có endpoint `/weather` trong lab:

```http
GET /weather?city=Hue HTTP/1.1
Host: api.example.test
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"city":"Hue","temperatureC":28}
```

Ta biết client yêu cầu đọc thông tin; tên các trường JSON do API định nghĩa. Không thể suy ra nhiệt độ chỉ từ request.

## 5. Lỗi thường gặp

- Cho rằng JSON request sẽ tự biến thành object Java mà không cần xử lý.
- Thấy body chứa `"status":404` rồi kết luận HTTP status là 404.
- Cho rằng gửi token bất kỳ là đã đăng nhập; `/echo` chỉ phản chiếu dữ liệu.
- Đồng nhất response lỗi của lab với quy tắc bắt buộc cho mọi API.

## 6. Tự kiểm tra

1. Từ request, phần nào quyết định method và phần nào là body?
2. Vì sao `GET /items?id=8` không phải `GET /items/8` nếu hợp đồng server chỉ hỗ trợ một dạng?
3. Có thể dự đoán nội dung database chỉ từ HTTP request không?
4. Một response 200 có thể biểu thị nghiệp vụ thất bại nếu API thiết kế kém không?
5. Vì sao phải đọc cả status, headers lẫn body?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Phân tích từng thành phần và dự đoán trường phản chiếu của request trong cases 1–2 ở `exercises.md`.
2. **Vừa:** So sánh GET/HEAD, body và status trong cases 3–5; giải thích bằng hợp đồng lab.
3. **Khó:** Phân tích cases 6–8, tách dự đoán chắc chắn khỏi giả định; tự thiết kế bảng kết quả trước/sau chạy.

`demo.http` chứa request mẫu gửi được sau khi khởi động lab theo README gốc. Làm dự đoán trong `exercises.md` trước khi chạy. Đối chiếu một số gợi ý tại [solutions](../../solutions/exercises/predict-request-response.md) sau khi tự giải.

Tham khảo chính thức: [HTTP Semantics — RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html).
