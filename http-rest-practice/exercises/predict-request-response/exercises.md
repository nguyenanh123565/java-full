# Bài tập dự đoán — TODO

## TODO 1 — Tách request

```http
GET /echo?name=An%20Binh&limit=2 HTTP/1.1
Host: localhost:8080
Accept: application/json
X-Lab-Header: request-parts
```

- TODO: Ghi method, path, query thô, headers và body của request này.
- TODO: `/echo` trả lại query thô, không phân tích các parameter. Dự đoán `rawQuery`; giải thích vì sao giá trị đó khác tên đã giải mã.
- TODO: Phân biệt header do bạn đặt với header client có thể tự thêm. Lab chỉ echo một nhóm headers, không phải mọi header.

## TODO 2 — Body không tự thành object

```http
POST /echo?source=ide HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{"name":"Lan","active":true}
```

- TODO: Lab `/echo` đưa body vào trường `receivedBody` dạng string, không parse JSON. Vẽ JSON response mà bạn dự đoán.
- TODO: Giải thích dấu escape khi một JSON string chứa dấu ngoặc kép.
- TODO: Thử body `{"name":` rồi giải thích `/echo` có kiểm tra cú pháp JSON không. API nghiệp vụ thật nên khác thế nào?

## TODO 3 — GET và HEAD

```http
HEAD /products/10 HTTP/1.1
Host: localhost:8080
```

- TODO: So sánh với `GET /products/10`; dự đoán status và body theo hợp đồng lab.
- TODO: Giải thích vì sao một response không có body chưa đủ để kết luận là lỗi.

## TODO 4 — Status và body

- TODO: Dự đoán response cho GET `/status/204`, `/status/404`, `/status/401`.
- TODO: Với 204, body có được chứa JSON không? Giải thích.
- TODO: Với 401, tìm header liên quan đến cơ chế xác thực; giải thích mục đích của header này.
- TODO: Tại sao `/status/401` không chứng minh lab đã triển khai đăng nhập?

## TODO 5 — HTTP status khác JSON field

API giả định trả:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"status":404,"message":"Product not found"}
```

- TODO: Client/proxy thấy HTTP status nào?
- TODO: Thiết kế lại status và body nhất quán, giải thích vì sao cần đổi.

## TODO 6 — Hợp đồng URL

- TODO: So sánh GET `/products/10` với GET `/products?id=10` trên lab.
- TODO: Ghi lại điều có thể kết luận từ bảng endpoint trong README gốc; không suy diễn query đã được lọc nếu lab không triển khai nó.
- TODO: Giải thích khác biệt giữa sai URL và tài nguyên không tồn tại.

## TODO 7 — PUT gửi hai lần

API giả định thay toàn bộ địa chỉ giao hàng bằng cùng một JSON qua PUT, client gửi hai lần vì timeout.

- TODO: Dự đoán trạng thái cuối; giải thích idempotent nói về điều gì.
- TODO: Hai response có nhất thiết cùng status và body không? Giải thích.
- TODO: Liệt kê thông tin thiếu khiến bạn chưa thể kết luận lần đầu có thành công không.

## TODO 8 — Ai quyết định schema?

Hai server khác nhau nhận cùng `GET /products/10` và cùng trả 200, nhưng JSON khác nhau.

- TODO: Giải thích vì sao cả hai có thể hợp lệ về HTTP.
- TODO: Viết hợp đồng cần thêm để client không đoán tên trường, kiểu dữ liệu và đơn vị tiền.
- TODO: Tạo bảng gồm dự đoán, quan sát, nguyên nhân chênh lệch cho ít nhất ba request lab.
