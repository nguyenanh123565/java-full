# Product Management — skeleton yêu cầu và TODO

## TODO 1 — Đọc và tìm kiếm

- TODO: Thiết kế lấy tất cả sản phẩm, lấy sản phẩm theo id, tìm theo tên.
- TODO: Thiết kế filter category và khoảng giá, có sort, giới hạn page/limit và tie-breaker.
- TODO: Tự viết request cho tên có dấu/dấu cách và category robot với minPrice 5.000.000.
- TODO: Quy định id không tồn tại, bộ lọc không có kết quả, minPrice > maxPrice, số âm và giá không phải số.
- TODO: Thiết kế response JSON với id, tên, giá, currency, stock và category theo cách bạn chọn.
- TODO: Giải thích path/query/body trong từng thao tác.

## TODO 2 — Ghi dữ liệu

- TODO: Thiết kế tạo sản phẩm cho admin; name, price, stock, category bắt buộc theo quy tắc bạn công bố.
- TODO: Thiết kế thay toàn bộ representation sản phẩm; tự chọn method, JSON và semantics field thiếu.
- TODO: Thiết kế chỉ cập nhật stock; tự chọn định dạng body và phân biệt đặt stock với tăng/giảm stock.
- TODO: Chọn status, headers và error JSON cho thành công, validation, sai Content-Type, category không tồn tại và thiếu quyền.
- TODO: Giải thích id do client hay server cấp; phân tích retry tạo sản phẩm sau timeout.

## TODO 3 — Lịch sử và xung đột

- TODO: Thiết kế xóa hoặc ngừng bán sản phẩm đã được bán; không làm mất đơn giá trong order cũ.
- TODO: Quy định lần xóa/ngừng bán thứ hai trả gì, trạng thái cuối ra sao.
- TODO: Phân tích hai admin cùng cập nhật stock; nêu cách phát hiện/thông báo xung đột ở mức hợp đồng HTTP.
- TODO: Mô tả stock bị thay đổi giữa lúc client đọc và ghi; thiết kế kiểm tra bạn cần.
- TODO: Viết ma trận success/error/permission/retry cho tám thao tác chính; giải thích ít nhất ba quyết định.

## TODO hồ sơ thiết kế

- TODO: Tạo `my-contract.md` để lưu quyết định, ví dụ và câu hỏi mở.
- TODO: Điền requests.http; ghi CHƯA TRIỂN KHAI cho mọi route filter/CRUD backend tương lai.
- TODO: Nhờ người khác đọc hợp đồng và chọn ba chỗ họ có thể hiểu khác bạn; sửa hợp đồng.
