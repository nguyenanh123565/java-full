# Bài tập 13 — Cookie / session / JWT

Không tạo token thật, không dùng credentials thật.

## 1. Dễ — Phân biệt ba chiều

Các từ: Cookie, Authorization, session id, JWT, server session store.

TODO:
- Phân loại cách vận chuyển, định dạng và nơi quản lý state.
- Vẽ ít nhất hai cách kết hợp hợp lệ.
- Giải thích vì sao “cookie hoặc JWT” có thể là câu hỏi thiếu chính xác.

## 2. Vừa — Login và logout bằng session

Một website đăng nhập qua HTTPS, lưu session id trong cookie và cần gọi API yêu cầu xác thực.

TODO:
- Viết chuỗi request/response login → API → logout bằng dữ liệu giả.
- Chọn thuộc tính cookie và giải thích ý nghĩa.
- Mô tả server tạo/kiểm tra/hủy session khi nào.
- Nêu một tình huống CSRF cần xem xét và cách xử lý ở mức thiết kế.

## 3. Khó — JWT và đổi quyền

Access token chứa sub, role, exp. User bị khóa khi token vẫn còn hạn. Hệ thống yêu cầu ngừng truy cập sớm hơn thời điểm hết hạn.

TODO:
- Phân tích decode, verify chữ ký và kiểm tra quyền hiện tại khác nhau thế nào.
- Đề xuất ít nhất hai policy, có trade-off.
- Nêu dữ liệu/state backend cần có nếu muốn thu hồi sớm.
- Giải thích vì sao JWT không tự giải quyết yêu cầu logout/khóa user.
