# Mini thiết kế — Order Management

## 1. Vấn đề cần giải quyết

Thiết kế API đặt hàng, xem đơn và hủy đơn có quy tắc nghiệp vụ rõ ràng. API không chỉ là một loạt CRUD: giá, quyền sở hữu, stock, chuyển trạng thái và retry đều cần được xử lý.

## 2. Vị trí trong luồng

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Backend kiểm tra người gọi và sản phẩm, tính tổng theo dữ liệu tin cậy, ghi order/items và giảm stock trong transaction. HTTP mô tả giao tiếp; transaction database giữ tính nhất quán khi lỗi giữa chừng. Bài này thiết kế contract, chưa kết nối JDBC hay PostgreSQL.

## 3. Kiến thức bắt buộc

- Order có id, chủ sở hữu, items, đơn giá tại thời điểm mua, total, status và thời gian.
- Client gửi lựa chọn sản phẩm/số lượng; backend xác định giá và tổng tiền, không tin total client gửi.
- Mỗi request cần đủ thông tin xác thực; tài khoản gọi phải có quyền trên order.
- Phân biệt trạng thái hợp lệ với chuyển trạng thái hợp lệ; PAID → CANCELLED có thể cần hoàn tiền.
- Hủy có thể là thay đổi trạng thái hoặc tạo resource cancellation khi cần vòng đời riêng; phải giải thích lựa chọn.
- Retry tạo/hủy và request đồng thời có thể làm ghi lặp hoặc hoàn stock hai lần nếu không có cơ chế nghiệp vụ.
- Status HTTP phản ánh kết quả thao tác; order.status phản ánh trạng thái đơn hàng.

## 4. Ví dụ ngoài bài tập

API giả định đọc một phương thức giao hàng, không có trong lab:

```http
GET /shipping-methods/2 HTTP/1.1
Host: api.example.test
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"id":2,"name":"Standard","fee":30000,"currency":"VND"}
```

Response HTTP 200 không phải trạng thái của một order.

## 5. Lỗi thường gặp

- Tin `userId`, `total`, `price` từ body mà bỏ qua danh tính và giá backend.
- Xem token hợp lệ là đủ để đọc order bất kỳ.
- Cho hủy order đã SHIPPED; hoàn stock mỗi lần retry.
- Trả 200 với lỗi thiếu hàng nhưng không có quy tắc lỗi nhất quán.
- Mô tả `BEGIN/COMMIT` trong request HTTP như thể client điều khiển transaction backend.

## 6. Tự kiểm tra

1. Vì sao total phải được backend tính?
2. Order.status khác HTTP response status thế nào?
3. Khi client timeout sau khi tạo order, lần retry có rủi ro gì?
4. Hủy order đã hủy khác hủy order SHIPPED thế nào?
5. Vì sao ghi order, items và stock cần cùng transaction?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Thiết kế đọc order theo id và orders của user; xử lý quyền, pagination, empty/not-found.
2. **Vừa:** Thiết kế tạo order, validation items, thiếu stock, total và response.
3. **Khó:** Thiết kế hủy order, retry và hai request đồng thời với bảng chuyển trạng thái.

Làm TODO trong `exercises.md`, viết `my-contract.md`, tự điền `requests.http`. Lab không có thao tác order; không gửi request này rồi mong có dữ liệu order thật. [Rubric](../../solutions/mini-api-designs/order-management.md) chỉ gợi ý tự kiểm tra, không có ma trận endpoint hoàn chỉnh.

Tham khảo: [HTTP Semantics — RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html).
