# Order Management — skeleton yêu cầu và TODO

Nghiệp vụ giả định: order có PENDING, PAID, SHIPPED, CANCELLED. Chỉ PENDING được hủy ngay; PAID cần quy trình hoàn tiền riêng. TODO: nêu giả định bổ sung nếu cần.

## TODO 1 — Xem đơn hàng

- TODO: Thiết kế đọc order theo id và lấy orders của một user, có filter status, sort, pagination.
- TODO: Thiết kế JSON gồm items, số lượng, đơn giá tại thời điểm mua, tổng tiền, currency và thời gian.
- TODO: Quy định user không tồn tại, user chưa có order, order không tồn tại, token thiếu/hỏng và người không sở hữu order.
- TODO: Giải thích quyền customer/admin và cách tránh user A đổi id để xem order của B.

## TODO 2 — Tạo order

- TODO: Thiết kế request chọn nhiều product và quantity; xác định dữ liệu nào lấy từ người gọi, dữ liệu nào backend tính.
- TODO: Quy định product không tồn tại, quantity <= 0, product lặp trong items, product ngừng bán, stock thiếu.
- TODO: Chọn method, URL, JSON, status và headers khi tạo thành công.
- TODO: Không tin giá/tổng/userId client tùy ý gửi; giải thích vì sao.
- TODO: Mô tả transaction backend gồm tạo order, order_items, giảm stock; nếu bước giữa lỗi, response và trạng thái dữ liệu phải ra sao?
- TODO: Thiết kế quy tắc retry sau timeout, nhận diện cùng yêu cầu và xử lý hai lần gửi đồng thời.

## TODO 3 — Hủy và chuyển trạng thái

- TODO: Viết bảng chuyển trạng thái cho PENDING/PAID/SHIPPED/CANCELLED; chọn thao tác nào customer hoặc admin được phép yêu cầu.
- TODO: Thiết kế hủy order với lý do; cân nhắc sửa status hay tạo cancellation resource và giải thích.
- TODO: Quy định lần hủy thứ hai, hủy order SHIPPED, hủy không đủ quyền và order không tồn tại.
- TODO: Chọn status cho xung đột trạng thái; không coi mọi lỗi là JSON hỏng.
- TODO: Phân tích hai request hủy cùng lúc; thiết kế contract để không hoàn stock hai lần.
- TODO: Viết ba cặp request/response thành công, bốn cặp lỗi và hai tình huống retry/timeout; giải thích vì sao.

## TODO hồ sơ thiết kế

- TODO: Tạo `my-contract.md` gồm resource, schema, errors, bảng chuyển trạng thái, quyền, retry và câu hỏi mở.
- TODO: Điền requests.http, ghi CHƯA TRIỂN KHAI; sau này mới dùng contract cho Java backend/JDBC.
- TODO: Đối chiếu với workspace SQL: giải thích quan hệ users/orders/order_items/products, không viết SQL vào body HTTP.
