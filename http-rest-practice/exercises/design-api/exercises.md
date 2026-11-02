# Thiết kế hợp đồng API — TODO

Với từng case, TODO: chọn method + URL; path/query/body; headers; JSON request/response; status thành công và ít nhất hai lỗi; quyền truy cập; giải thích vì sao. TODO: ghi giả định thay vì đoán quy tắc nghiệp vụ.

## TODO 1 — Lấy tất cả sản phẩm

- TODO: Thiết kế collection có limit, phân trang và sort ổn định.
- TODO: Quy định mặc định, giới hạn tối đa, collection rỗng và query không hợp lệ.
- TODO: Giải thích vì sao trả mọi dòng không giới hạn có vấn đề với backend thật.

## TODO 2 — Lấy sản phẩm theo id

- TODO: Chọn chỗ đặt id, kiểu id và hành vi khi id sai định dạng hoặc không tồn tại.
- TODO: Thiết kế JSON cho sản phẩm; ghi rõ đơn vị giá và trạng thái còn hàng.
- TODO: Giải thích collection với một bộ lọc khác tài nguyên định danh thế nào.

## TODO 3 — Tìm sản phẩm theo tên

- TODO: Quy định tìm chính xác hay chứa chuỗi, phân biệt hoa/thường, tên có dấu cách.
- TODO: Viết request tìm tên “robot hút bụi” với encoding phù hợp.
- TODO: Quy định tên rỗng và không có kết quả; giải thích lựa chọn.

## TODO 4 — Filter category và price

Yêu cầu: category robot, giá tối thiểu 5.000.000, giá tối đa 12.000.000.

- TODO: Chọn query names và kiểu dữ liệu; phân biệt category id với slug.
- TODO: Quy định min > max, giá âm, dấu phân cách số và nhiều giá trị category.
- TODO: Kết hợp sort và phân trang; giải thích thứ tự ổn định.

## TODO 5 — Tạo sản phẩm

- TODO: Thiết kế request name, price, stock, category; không để client tùy ý ghi id do server cấp.
- TODO: Chọn response status, body, header định vị tài nguyên mới.
- TODO: Quy định category không tồn tại, stock âm, sai Content-Type và thiếu quyền.
- TODO: Giải thích retry sau timeout có thể tạo hai sản phẩm không.

## TODO 6 — Cập nhật toàn bộ sản phẩm

- TODO: Chọn method cho thay thế representation; phân biệt field do server quản lý với field client được thay.
- TODO: Quy định bỏ quên price hoặc stock có lỗi hay dùng mặc định; giải thích.
- TODO: Gửi cùng request hai lần và mô tả trạng thái cuối.

## TODO 7 — Cập nhật riêng stock

- TODO: Chọn method và công bố định dạng body; phân biệt đặt stock = 10 với tăng stock thêm 10.
- TODO: Quy định null, số âm, thiếu field, body có field lạ và xung đột cập nhật đồng thời.
- TODO: Giải thích request nào có thể retry an toàn theo hợp đồng bạn chọn.

## TODO 8 — Xóa sản phẩm

- TODO: Quy định xóa thật hay ngừng bán khi sản phẩm đã có trong order cũ.
- TODO: Chọn status lần đầu/lần lặp; giải thích idempotency của trạng thái cuối.
- TODO: Đảm bảo giá và tên trong lịch sử order không biến mất do xóa sản phẩm.

## TODO 9 — Lấy mọi order của một user

- TODO: Thiết kế URL thể hiện quan hệ user–orders; có phân trang và filter status.
- TODO: Quy định ai được xem dữ liệu: chủ tài khoản và admin; trường hợp user A đổi id sang B.
- TODO: Phân biệt user không tồn tại với user chưa có order; giải thích response.

## TODO 10 — Hủy order

Order có trạng thái PENDING, PAID, SHIPPED, CANCELLED. Chỉ PENDING được hủy ngay; PAID cần quy trình hoàn tiền khác.

- TODO: Thiết kế thao tác hủy, lý do hủy và response; xem xét chuyển trạng thái hoặc tạo tài nguyên cancellation.
- TODO: Quy định hủy lại một order đã hủy và hủy order SHIPPED.
- TODO: Phân biệt thiếu quyền với trạng thái không cho phép hủy.
- TODO: Mô tả tình huống hai request hủy cùng lúc; tránh hoàn stock hai lần.

## TODO 11 — Chuyển RPC-style sang RESTful

```http
POST /getProduct?id=10 HTTP/1.1
Content-Type: application/json

{}
```

- TODO: Nhận xét method, URL, query và body hiện tại.
- TODO: Thiết kế lại cho mục đích đọc một sản phẩm; giải thích từng thay đổi.
- TODO: Phân biệt REST là phong cách kiến trúc với quy ước đặt tên URL phổ biến.

## TODO tự chấm

- TODO: Tạo ma trận 10 nghiệp vụ × method/URL/input/output/errors/permission/retry.
- TODO: Cho người khác dùng hợp đồng của bạn mà không hỏi thêm tên field; ghi lại phần còn mơ hồ.
- TODO: Chọn ba quyết định và viết cách thiết kế thay thế cùng lý do không chọn.
