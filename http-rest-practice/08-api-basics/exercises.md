# Bài tập 08 — API basics

Chỉ có đề bài. Ghi câu trả lời, giả định và lý do của bạn ngay dưới mỗi TODO.

## 1. Dễ — Giao kèo đọc product

Một client cần đọc product có id 42. Hãy xác định method, URL, input, JSON thành công và ít nhất hai trường hợp lỗi. Backend có thể thay đổi cách lưu dữ liệu.

TODO:
- Viết giao kèo, không viết Java hoặc SQL.
- Phân biệt bảo đảm của giao kèo với chi tiết nội bộ.
- Giải thích vì sao client không cần biết tên bảng.

## 2. Vừa — Giao kèo tạo user

User có tên, email và thông tin đăng nhập. Backend còn lưu id, ngày tạo và password hash.

TODO:
- Phân loại trường do client gửi và trường backend tạo.
- Chọn validation, response và các lỗi cần mô tả.
- Giải thích vì sao từng trường được phép hoặc không được phép xuất hiện trong response.

## 3. Khó — Mở rộng giao kèo

API danh sách orders đang trả một JSON array. Backend muốn thêm tổng số phần tử và pagination.

TODO:
- Đề xuất ít nhất hai phương án tương thích hoặc migration.
- Viết ví dụ giao kèo trước/sau bằng dữ liệu tự chọn.
- Giải thích ảnh hưởng tới client đang đọc JSON array.
