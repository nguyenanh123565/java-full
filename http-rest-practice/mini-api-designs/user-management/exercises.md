# User Management — skeleton yêu cầu và TODO

## TODO 1 — Đọc tài nguyên

- TODO: Thiết kế xem user theo id và danh sách users có phân trang, filter tên/email dành cho người có quyền.
- TODO: Tự chọn method/URL, path/query, response JSON; không trả dữ liệu bí mật.
- TODO: Quy định id sai định dạng, id không tồn tại, collection rỗng, query sai và page quá giới hạn.
- TODO: Giải thích sự khác nhau giữa model lưu database và representation trả client.

## TODO 2 — Tạo và cập nhật

- TODO: Thiết kế tạo user: name/email bắt buộc; email phải theo quy tắc duy nhất bạn công bố.
- TODO: Thiết kế cập nhật riêng tên và cập nhật representation có thể chỉnh sửa; quy định field bỏ qua, null và field lạ.
- TODO: Chọn status, headers và JSON cho thành công, duplicate email, validation lỗi và Content-Type không hỗ trợ.
- TODO: Không cho client tự gán role; giải thích field nào server quản lý và vì sao.
- TODO: Phân tích retry sau timeout và hai request đổi email đồng thời.

## TODO 3 — Quyền và vòng đời

- TODO: Tạo ma trận quyền guest/customer/admin; ai được đọc, tạo, sửa, ngừng hoạt động user nào?
- TODO: Thiết kế xem orders của một user có pagination/status filter.
- TODO: Phân tích customer id 7 đổi path sang user 99; mô tả kiểm tra quyền và response bạn chọn.
- TODO: Thiết kế ngừng hoạt động user đã có orders; lịch sử đơn hàng cần còn xem được theo chính sách nào?
- TODO: Quy định thiếu xác thực, không đủ quyền và resource không tồn tại; giải thích trade-off khi che giấu sự tồn tại.
- TODO: Viết ba cặp request/response thành công, ba cặp lỗi và hai tình huống retry.

## TODO hồ sơ thiết kế

- TODO: Tạo `my-contract.md` gồm mục tiêu, giả định, bảng thao tác, JSON schema đơn giản, status/error, quyền, retry và câu hỏi chưa giải quyết.
- TODO: Điền requests.http bằng request do bạn tự thiết kế; đánh dấu CHƯA TRIỂN KHAI.
- TODO: Viết ít nhất ba câu giải thích “vì sao” cho những quyết định bạn chọn.
