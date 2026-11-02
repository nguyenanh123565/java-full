# Bài tự làm — SecurityFilterChain trước controller

- TODO: Đọc reference chain, vẽ thứ tự khái niệm và ghi điểm request bị dừng khi thiếu CSRF/role/session.
- TODO: Dự đoán trước khi chạy: ghi kết quả cho một trường hợp hợp lệ và một trường hợp biên/lỗi; dự đoán status nếu có HTTP.
- TODO: Giải thích **vì sao** cơ chế trong bài phù hợp hơn việc dồn mọi thứ vào một hàm main/controller.
- TODO: Liên hệ kiến thức cũ: So sánh exception ở service với request bị filter từ chối: vì sao SQL log có thể không có gì?
- TODO: Ghi cách tái hiện, kết quả thật và điều đã sửa trong suy nghĩ; không chỉ ghi “đã chạy”.

Không đọc thư mục solution trong lần thử đầu. Không cần cài thêm dependency chỉ để làm bài đọc mã/thiết kế.
