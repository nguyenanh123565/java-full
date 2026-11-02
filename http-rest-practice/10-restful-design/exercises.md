# Bài tập 10 — Thiết kế API

Chỉ thiết kế, chưa viết Spring Boot hoặc backend CRUD.

## 1. Dễ — Đọc products

Nghiệp vụ: lấy tất cả sản phẩm; lấy theo id; tìm theo tên; filter category = robot và giá tối thiểu 5000000, đồng thời có giá tối đa tùy chọn.

TODO:
- Chọn method, URL, path/query và quy tắc validation.
- Viết JSON thành công và ít nhất một lỗi cho từng trường hợp.
- Giải thích collection rỗng và id không tồn tại khác nhau thế nào.

## 2. Vừa — Sửa products

Nghiệp vụ: tạo sản phẩm; cập nhật toàn bộ thông tin client quản lý; cập nhật riêng stock; xóa sản phẩm.

TODO:
- Thiết kế bốn giao kèo request/response.
- Nêu trường read-only, trường bắt buộc, media type và ý nghĩa thiếu trường/null.
- Chọn status cho success và dữ liệu sai.
- Giải thích vì sao method phù hợp với ý định.

## 3. Khó — Orders của user và hủy order

User cần xem đơn của mình và hủy đơn còn pending. Đơn paid hoặc shipped không được hủy theo quy tắc của bài.

TODO:
- Thiết kế URL, method và representation.
- Xác định cách backend kiểm tra resource ownership.
- Quy định retry hủy đơn đã hủy, lỗi state và các tình huống cạnh tranh.
- Giải thích vì sao hủy khác xóa lịch sử.
