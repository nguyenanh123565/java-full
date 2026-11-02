# Gợi ý chọn lọc — thiết kế API

Không có ma trận đáp án cho cả 10 nghiệp vụ. Hãy hoàn thành bản thiết kế trước khi dùng rubric.

## Một mẫu: lấy product theo id

Một hợp đồng hợp lý là `GET /products/10`, request `Accept: application/json`; 200 với JSON product khi tồn tại, 404 khi không tồn tại, 400 khi id sai định dạng theo hợp đồng. Response có thể gồm `id`, `name`, `price`, `currency`, `stock`, `categoryId`; đơn vị tiền phải được định nghĩa. GET không yêu cầu client gửi body để chọn id.

Đây là thiết kế tham khảo; lab chỉ có product mẫu id 10, không phải backend CRUD đầy đủ.

## Rubric cho các case bạn tự làm

Chấm mỗi case 0–2 điểm cho mỗi tiêu chí: resource/method rõ; input rõ kiểu/vị trí; success response nhất quán; validation/error rõ; quyền đúng; retry và dữ liệu lớn đã được xem xét. 0 = thiếu, 1 = có nhưng mơ hồ, 2 = có ví dụ và giải thích.

- Case 1/3/4: Có giới hạn, sort ổn định, encoding và quy tắc filter? Collection rỗng có khác id không tồn tại?
- Case 5/6/7: Field server quản lý được bảo vệ? PUT thiếu field khác PATCH thiếu field? Body PATCH có semantics được công bố?
- Case 8: Lịch sử order có còn đúng sau xóa/ngừng bán?
- Case 9: User A đổi path id sang B có đọc được order của B không?
- Case 10: Có bảng chuyển trạng thái? PATCH status hoặc tạo cancellation resource đều có thể phù hợp khi contract rõ; cân nhắc quyền, refund, retry và xung đột trước khi chọn.
- Case 11: Giải thích cách đọc theo resource và semantics method; không chỉ thay tên URL.

Đừng tự chấm chỉ vì URL “trông REST”. Người khác phải viết được client dựa vào hợp đồng của bạn.

Tham khảo: [RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html), [RFC 5789](https://www.rfc-editor.org/rfc/rfc5789.html).
