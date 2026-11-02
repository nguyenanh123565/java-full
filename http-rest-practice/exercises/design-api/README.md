# Thiết kế API từ nghiệp vụ

## 1. Vấn đề cần giải quyết

Chuyển yêu cầu như “khách tìm sản phẩm còn hàng” thành hợp đồng mà frontend, backend và người kiểm thử đều hiểu: method, URL, dữ liệu vào, dữ liệu ra, lỗi và quyền truy cập.

## 2. Vị trí trong luồng

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Bạn thiết kế hai hợp đồng HTTP; backend chịu trách nhiệm validation, quyền truy cập và nghiệp vụ trước khi đọc/ghi database. Tên endpoint không cần trùng từng bảng PostgreSQL.

## 3. Kiến thức bắt buộc

- Xác định resource và collection trước khi chọn method.
- Dùng path để định danh; query cho tìm kiếm, lọc, sắp xếp, phân trang; body cho dữ liệu cần gửi theo hợp đồng.
- PUT thay thế representation theo hợp đồng; PATCH mô tả thay đổi một phần với định dạng patch được công bố.
- Phân biệt thiếu xác thực, thiếu quyền, không tìm thấy, validation lỗi và xung đột trạng thái.
- Định nghĩa JSON nhất quán, loại tiền và đơn vị tiền; không để client quyết định tổng tiền order.
- GET collection phải có cách giới hạn dữ liệu và thứ tự ổn định, ví dụ thêm id để phá hòa khi sort theo giá.
- Request chỉ có user id không đủ chứng minh người gọi được phép truy cập user đó.
- Ghi hành vi retry, field bị bỏ qua, field null, và cập nhật đồng thời.

## 4. Ví dụ ngoài bài tập

Hợp đồng giả định về tác giả sách:

```http
GET /authors/7/books?limit=5 HTTP/1.1
Host: api.example.test
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"items":[{"id":31,"title":"Learning HTTP"}],"limit":5}
```

Path định danh tác giả; query giới hạn collection sách. Thiết kế giả định này không phải route được lab triển khai.

## 5. Lỗi thường gặp

- Dùng GET để tạo/xóa hoặc POST cho mọi thao tác vì dễ gửi JSON.
- Để URL chứa các tên như `getAll`, `createNew`, `updateProduct` thay vì bắt đầu từ tài nguyên.
- Trả 200 cho mọi lỗi; vô tình lộ password hash trong response user.
- Bỏ qua giới hạn phân trang, quyền sở hữu order và retry tạo đơn.

## 6. Tự kiểm tra

1. Khi nào id nên nằm trên path thay vì body?
2. Vì sao request PATCH tăng stock thêm 1 khác PATCH đặt stock thành 1?
3. Hủy order là chuyển trạng thái hay tạo resource hủy? Cần điều kiện gì để quyết định?
4. Collection rỗng và tài nguyên theo id không tồn tại nên được diễn đạt khác nhau thế nào?
5. Vì sao response order cần có đơn giá tại thời điểm mua?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Thiết kế các thao tác đọc sản phẩm trong cases 1–4.
2. **Vừa:** Thiết kế các thao tác ghi trong cases 5–8; ghi rõ validation, quyền và status.
3. **Khó:** Thiết kế orders của user và hủy order trong cases 9–10, xử lý retry và chuyển trạng thái; phản biện một API RPC trong case 11.

Viết đáp án của bạn vào file mới như `my-design.md`. `requests.http` chỉ có comment TODO; bạn tự điền request theo hợp đồng mình chọn. Lab chưa có CRUD, không dùng response lab để xác nhận tính đúng đắn của mọi thiết kế. [Solutions](../../solutions/exercises/design-api.md) chỉ đưa một mẫu đọc và rubric để bạn tự đối chiếu.

Tham khảo: [HTTP Semantics — RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html), [HTTP PATCH — RFC 5789](https://www.rfc-editor.org/rfc/rfc5789.html).
