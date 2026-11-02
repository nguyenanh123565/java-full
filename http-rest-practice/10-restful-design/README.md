# 10 — Thiết kế giao kèo API theo tài nguyên

## 1. Khái niệm giải quyết vấn đề gì?

Thiết kế API biến nghiệp vụ thành giao kèo mà client có thể dự đoán: đọc tài nguyên nào, sửa phần nào, nhận thành công/lỗi ra sao. Cần thống nhất trước khi viết controller hoặc SQL.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

Bạn thiết kế request/response ở hai đầu và quy tắc nghiệp vụ backend ở giữa. Một thay đổi resource có thể cần nhiều thao tác database trong một transaction; URL không cần thể hiện các bảng nội bộ.

## 3. Kiến thức bắt buộc

- Định danh một resource bằng path; filter/sort/pagination thường nằm ở query; dữ liệu tạo/sửa thường ở body.
- GET đọc; POST yêu cầu xử lý/tạo theo giao kèo; PUT tạo hoặc thay thế trạng thái tại URI; PATCH áp dụng sửa đổi theo định dạng đã thống nhất; DELETE yêu cầu bỏ liên kết với tài nguyên tại URI.
- PUT replacement cần nói rõ các trường client quản lý, trường read-only và ý nghĩa khi thiếu trường.
- PATCH không có định dạng mặc định. Phải nêu media type và ngữ nghĩa; thiếu trường khác `null`.
- Status và lỗi là phần giao kèo: 201/Location khi tạo, 204 không có body, 400/404/409/415/422 theo tình huống.
- Collection rỗng thường vẫn là `200` với danh sách rỗng; không đồng nghĩa endpoint không tồn tại.
- Hủy đơn là chuyển trạng thái nghiệp vụ; xác định trạng thái được phép, quyền, retry và xung đột.
- Danh từ số nhiều và nested URL là quy ước; một nghiệp vụ có thể có nhiều mô hình hợp lý.

## 4. Ví dụ request/response

Ví dụ thiết kế warehouses, không phải endpoint của lab. Minh họa HTTP/1.1; framing được lược bớt.

```http
PATCH /warehouses/3 HTTP/1.1
Host: api.example.test
Content-Type: application/merge-patch+json
Accept: application/json

{"name":"Central"}

HTTP/1.1 200 OK
Content-Type: application/json

{"id":3,"name":"Central","capacity":100}
```

Ở giao kèo này, trường capacity vắng mặt nghĩa là giữ nguyên. Nếu API chấp nhận JSON Merge Patch, nó phải xử lý đúng quy tắc định dạng và công bố trường được sửa; không chỉ đổi tên Content-Type.

`demo.http` dùng echo để quan sát method/query/body; echo không sửa product.

## 5. Lỗi thường gặp

- GET để tạo dữ liệu hoặc xóa resource.
- PUT nhưng âm thầm giữ tất cả trường thiếu như PATCH.
- Dùng một endpoint cho nhiều thao tác mà không có giao kèo rõ.
- Trả 204 kèm JSON body.
- Cho client gửi total của order rồi tin đó là số tiền thanh toán đúng.
- Xóa order chỉ vì muốn hủy nghiệp vụ, làm mất lịch sử.

## 6. Tự kiểm tra

1. Filter theo giá nên khác nhận diện một product như thế nào?
2. PUT và PATCH khác nhau khi một trường không có trong body?
3. Khi nào response tạo tài nguyên nên có Location?
4. Vì sao hủy đơn và xóa lịch sử đơn có thể là hai nghiệp vụ khác nhau?
5. Collection rỗng và resource không tồn tại khác nhau ra sao?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Thiết kế đọc products: danh sách, theo id, tìm tên, filter category/price. Giải thích path/query và status khi không có kết quả.
2. **Vừa:** Thiết kế tạo product, thay thế toàn bộ, chỉ sửa stock và xóa. Viết request/response cùng validation; nêu rõ PUT/PATCH.
3. **Khó:** Thiết kế lấy orders của user và hủy order; viết quy tắc quyền, trạng thái, retry, xung đột và lỗi.

Làm trong [exercises.md](exercises.md); solution riêng ở [solutions](../solutions/10-restful-design.md).

Nguồn: [RFC 5789 — PATCH](https://www.rfc-editor.org/rfc/rfc5789), [RFC 7396 — JSON Merge Patch](https://www.rfc-editor.org/rfc/rfc7396).
