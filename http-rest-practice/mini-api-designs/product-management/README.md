# Mini thiết kế — Product Management

## 1. Vấn đề cần giải quyết

Thiết kế API danh mục sản phẩm cho người mua tìm kiếm và admin quản lý. Từ yêu cầu nghiệp vụ, bạn chọn resource, method, query và JSON có hợp đồng rõ; chưa viết backend CRUD.

## 2. Vị trí trong luồng

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Client mô tả lựa chọn; backend kiểm tra filter và quyền, query database theo tiêu chí, rồi trả representation. Với cập nhật stock, backend còn phải giữ ràng buộc không âm và xử lý cập nhật đồng thời.

## 3. Kiến thức bắt buộc

- Collection và resource theo id có ý nghĩa khác nhau; filter không làm thay đổi dữ liệu.
- Path cho định danh; query cho tìm tên/category/giá, sort và phân trang.
- Chọn kiểu số và đơn vị tiền; category id khác slug.
- PUT thay thế representation được công bố; PATCH sửa một phần theo định dạng và semantics đã chọn.
- Stock “đặt bằng” khác “cộng thêm”; retry phải được thiết kế phù hợp.
- Một sản phẩm trong order lịch sử cần giữ thông tin tại thời điểm mua, kể cả khi danh mục thay đổi.
- Dữ liệu mẫu trong lab chỉ để quan sát HTTP, không thực hiện filter/CRUD đầy đủ.

## 4. Ví dụ ngoài bài tập

API giả định đọc thông tin một kho hàng; không được lab triển khai:

```http
GET /warehouses/3 HTTP/1.1
Host: api.example.test
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"id":3,"name":"Warehouse East","active":true}
```

Id xác định kho, JSON biểu diễn những field API công bố; không bắt buộc lộ nguyên cấu trúc bảng.

## 5. Lỗi thường gặp

- Filter giá nhưng nhận chuỗi như “5 triệu” không có quy tắc parse.
- Dùng GET để sửa stock hoặc đổi tên sản phẩm.
- Sort theo giá nhưng thiếu tie-breaker khi hai sản phẩm cùng giá.
- Cho client cập nhật id, giá âm, stock âm hoặc category không tồn tại.
- Xóa sản phẩm khiến lịch sử order mất dữ liệu.

## 6. Tự kiểm tra

1. Min/max price nên ở query hay body của thao tác đọc?
2. PUT thiếu stock khác PATCH thiếu stock thế nào theo hợp đồng bạn chọn?
3. PATCH đặt stock = 10 và tăng stock thêm 10 khác nhau khi retry ra sao?
4. Vì sao collection rỗng khác product id không tồn tại?
5. Khi sản phẩm đã bán, xóa thật và ngừng bán có trade-off gì?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Thiết kế list/get/search/filter với JSON và phân trang ổn định.
2. **Vừa:** Thiết kế create/PUT/PATCH, validation, quyền và status.
3. **Khó:** Thiết kế delete/ngừng bán và cập nhật stock đồng thời, giữ lịch sử order và xử lý retry.

Tự hoàn thành `exercises.md` và điền `requests.http`. Lab chỉ có GET collection và product mẫu 10; query/filter/CRUD của bạn chưa được triển khai. [Rubric](../../solutions/mini-api-designs/product-management.md) không chứa toàn bộ endpoint đáp án.

Tham khảo: [HTTP Semantics — RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html), [PATCH — RFC 5789](https://www.rfc-editor.org/rfc/rfc5789.html).
