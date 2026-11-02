# Hợp đồng cố tình sai — TODO

Với mỗi case: TODO tìm ít nhất hai vấn đề; viết hợp đồng tốt hơn; giải thích hậu quả của bản cũ và trade-off của bản mới. Các request dưới đây là dữ kiện lỗi, không phải đáp án hay route đang chạy.

## TODO 1 — GET xóa dữ liệu

```http
GET /deleteProduct?id=10 HTTP/1.1
```

Backend xóa product ngay khi nhận request. TODO: phân tích safe method, link preview, quyền truy cập và lịch sử order; tự sửa.

## TODO 2 — POST để đọc

```http
POST /getProduct?id=10 HTTP/1.1
Content-Type: application/json

{}
```

TODO: nhận xét; thiết kế RESTful hơn cho đọc theo id; giải thích method, URL và body.

## TODO 3 — URL toàn động từ

```text
/doCreateUser
/getAllProducts
/updateAllProductFields
/changeProductStock
```

TODO: chuyển sang resource-oriented; chọn method; giải thích vì sao không chỉ đổi tên URL.

## TODO 4 — Mọi response đều 200

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"success":false,"error":"email already exists"}
```

TODO: chọn status phù hợp; xây dựng error JSON nhất quán; phân biệt duplicate email, JSON hỏng và lỗi database ngoài dự kiến. TODO: không đưa SQL, stack trace hoặc mật khẩu vào response.

## TODO 5 — Nhầm input và quyền

```http
POST /products?name=Robot&price=5000000&admin=true HTTP/1.1
```

Server tin `admin=true` là quyền quản trị. TODO: chọn vị trí dữ liệu sản phẩm; xác định nguồn quyền đáng tin; phân tích rò rỉ dữ liệu qua URL/log.

## TODO 6 — JSON mơ hồ

```json
{"id":"10","price":"5 triệu","stock":null,"passwordHash":"SECRET"}
```

API dùng cùng object cho user và product. TODO: tách representation theo tài nguyên; quy định kiểu, đơn vị tiền, null và field chỉ dùng nội bộ. TODO: giải thích vì sao tên field phải ổn định.

## TODO 7 — User A xem order của B

```http
GET /users/99/orders HTTP/1.1
Authorization: Bearer TOKEN_OF_USER_7
```

Backend chỉ kiểm tra token hợp lệ rồi trả mọi order của user 99. TODO: tìm thiếu sót; thiết kế kiểm tra quyền và response khi bị từ chối; giải thích id trên path không chứng minh quyền sở hữu.

## TODO 8 — Retry làm tăng stock hai lần

```http
PATCH /products/10 HTTP/1.1
Content-Type: application/json

{"increaseStockBy":5}
```

Lần đầu timeout, client tự gửi lại. TODO: phân tích trạng thái cuối; thiết kế semantics hoặc cơ chế chống lặp; giải thích vì sao tên PATCH không tự đảm bảo idempotency.

## TODO 9 — Phân trang không ổn định

GET collection trả 100.000 products, hoặc phân trang bằng giá nhưng nhiều product cùng giá và không có tie-breaker.

TODO: giới hạn response; quy định sort và tie-breaker; giải thích dữ liệu bị trùng/bỏ sót giữa hai trang, và điều vẫn có thể xảy ra khi dữ liệu thay đổi.

## TODO 10 — Hủy bất kỳ order

```http
GET /cancelOrder?id=21 HTTP/1.1
```

Backend cho mọi user hủy order, kể cả đã SHIPPED; mỗi lần gọi đều hoàn stock.

TODO: thiết kế quyền, chuyển trạng thái, method, body và status; quy định retry và request đồng thời; giải thích khi nào cân nhắc tài nguyên cancellation thay vì cập nhật status trực tiếp.
